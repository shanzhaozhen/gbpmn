package org.shanzhaozhen.gbpmn.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.shanzhaozhen.gbpmn.core.builder.GProcessParse;
import org.shanzhaozhen.gbpmn.core.constant.ProcessActionType;
import org.shanzhaozhen.gbpmn.core.constant.ProcessStatus;
import org.shanzhaozhen.gbpmn.core.constant.RejectType;
import org.shanzhaozhen.gbpmn.core.constant.RuntimeStatus;
import org.shanzhaozhen.gbpmn.core.mapper.*;
import org.shanzhaozhen.gbpmn.core.pojo.entity.*;
import org.shanzhaozhen.gbpmn.core.queue.GbpmnProducer;
import org.shanzhaozhen.gbpmn.core.service.IProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements IProcessService {

    private final ProcessTemplateMapper processTemplateMapper;
    private final ProcessInstanceMapper processInstanceMapper;
    private final ProcessRuntimeMapper processRuntimeMapper;
    private final ProcessRecordMapper processRecordMapper;
    private final ProcessDiagramTemplateMapper processDiagramTemplateMapper;
    private final GbpmnProducer gbpmnProducer;

    @Override
    @Transactional
    public void addProcess(ProcessInstance processInstance) {
        // 获取流程模板
        ProcessTemplate processTemplate = processTemplateMapper.getProcessTemplateByIdAndVersion(processInstance.getTemplateId(), processInstance.getTemplateVersion());

        // todo: 根据主题生成规则生成对应的流程主题
        String subject = processTemplate.getSubjectRule();

        // todo: 根据编码规则生成对应的流程号
        String number = processTemplate.getNumberRuleId();

        processInstance.setSubject(subject);
        processInstance.setNumber(number);

        // 生成流程实例
        processInstanceMapper.insert(processInstance);

        // 获取流程图模板
        ProcessDiagramTemplate processDiagramTemplate = processDiagramTemplateMapper
                .getProcessDiagramTemplateByIdAndVersion(processTemplate.getProcessDiagramTemplateId(),
                        processTemplate.getProcessDiagramTemplateVersion());

        // 流程图 json 数组转换
        // todo: 做 redis 缓存
        GProcess gProcess = GProcessParse.jsonToGProcess(processDiagramTemplate.getDetail());
        GNode startNode = gProcess.getStartNode();

        // 生成流程运行时状态持久化
        ProcessRuntime processRuntime = new ProcessRuntime();

        processRuntime
                .setProcessId(processInstance.getId())                              // 流程实例ID
                .setTemplateId(processTemplate.getProcessDiagramTemplateId())       // 流程引用流程模板图模板ID
                .setTemplateVersion(processTemplate.getContextTemplateVersion())    // 流程引用流程模板图模板版本号
                .setNodeId(startNode.getId())                                       // 当前停留节点ID
                .setStatus(RuntimeStatus.READY.getCode())                           // 当前运行状态
        ;

        processRuntimeMapper.insert(processRuntime);

        // 将节点发送到队列中
        gbpmnProducer.pushQueue(processRuntime.getId());
    }

    public GProcess getProcessDiagram(ProcessRuntime processRuntime) {
        String detail;

        // 如果流程实施化后修改过流程则跟随修改
        if (StringUtils.hasText(processRuntime.getDetail())) {
            detail = processRuntime.getDetail();
        } else {
            ProcessDiagramTemplate processDiagramTemplate = processDiagramTemplateMapper
                    .getProcessDiagramTemplateByIdAndVersion(processRuntime.getTemplateId(),
                            processRuntime.getTemplateVersion());

            Assert.notNull(processDiagramTemplate, "该流程模板不存在, 模板ID：" + processRuntime.getTemplateId() + "，版本号：" + processRuntime.getTemplateVersion());
            detail = processDiagramTemplate.getDetail();
        }

        // 流程图 json 数组转换
        // todo: 做 redis 缓存
        return GProcessParse.jsonToGProcess(detail);
    }

    public void approvalProcess(ProcessAction processAction) {
        ProcessInstance processInstance = processInstanceMapper.selectById(processAction.getProcessId());
        Assert.notNull(processInstance, "该流程实例不存在，流程ID：" + processInstance);

        ProcessRuntime processRuntime = processRuntimeMapper.getProcessRuntimeByProcessId(processAction.getProcessId());
        Assert.notNull(processRuntime, "该流程不存在或已被处理");

        GProcess processDiagram = getProcessDiagram(processRuntime);

        // 进行对应的操作
        if (ProcessActionType.AGREE.getCode().equals(processAction.getActionType())) {              // 通过审批
            processAgree(processRuntime, processAction);
        } else if (ProcessActionType.REJECT.getCode().equals(processAction.getActionType())) {      // 驳回
            processReject(processInstance, processRuntime, processAction);
        } else {
            throw new IllegalArgumentException("非法操作，流程ID：" + processInstance);
        }

        // 将节点发送到队列中
        gbpmnProducer.pushQueue(processRuntime.getId());
    }

    public void processAgree(ProcessRuntime processRuntime, ProcessAction processAction) {
        GProcess processDiagram = getProcessDiagram(processRuntime);
        GNode currentNode = processDiagram.getNode(processRuntime.getNodeId());

        // 记录流程操作
        ProcessRecord processRecord = ProcessRecord.builder()
                .content(processAction.getContent())
                .nodeId(processRuntime.getNodeId())
                .nodeName(currentNode.getId())
                .operatorId("")
                .operatorType(ProcessActionType.AGREE.getName())
                .build();
        processRecordMapper.insert(processRecord);

        // 计算流程将执行的下一个节点
        GNode nextNode = processDiagram.getNextNode(processRuntime.getNodeId());

        // 更新流程运行时状态
        processRuntime
                .setNodeId(nextNode.getId())
                .setStatus(RuntimeStatus.READY.getCode())
        ;
        processRuntimeMapper.updateById(processRuntime);
    }

    public void processReject(ProcessInstance processInstance, ProcessRuntime processRuntime, ProcessAction processAction) {
        GProcess processDiagram = getProcessDiagram(processRuntime);
        GNode currentNode = processDiagram.getNode(processRuntime.getNodeId());

        // 记录流程操作
        ProcessRecord processRecord = ProcessRecord.builder()
                .content(processAction.getContent())
                .nodeId(processRuntime.getNodeId())
                .nodeName(currentNode.getId())
                .operatorId("")
                .operatorType(ProcessActionType.REJECT.getName() + "-" + processAction.getRejectType())
                .build();
        processRecordMapper.insert(processRecord);

        GNode nextNode = processDiagram.getStartNode();

        // 更新流程运行时状态
        processRuntime
                .setNodeId(nextNode.getId())
                .setStatus(RuntimeStatus.READY.getCode())
        ;
        processRuntimeMapper.updateById(processRuntime);

        // 更新流程实例状态
        processInstance.setSubject(ProcessStatus.REJECT.getCode());
        processInstanceMapper.updateById(processInstance);
    }

    public void processTransfer() {

    }

    public void processAbandon() {

    }

}
