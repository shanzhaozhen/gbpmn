package org.shanzhaozhen.gbpmn.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.shanzhaozhen.gbpmn.core.builder.GProcessParse;
import org.shanzhaozhen.gbpmn.core.constant.RuntimeStatus;
import org.shanzhaozhen.gbpmn.core.mapper.ProcessDiagramTemplateMapper;
import org.shanzhaozhen.gbpmn.core.mapper.ProcessInstanceMapper;
import org.shanzhaozhen.gbpmn.core.mapper.ProcessRuntimeMapper;
import org.shanzhaozhen.gbpmn.core.mapper.ProcessTemplateMapper;
import org.shanzhaozhen.gbpmn.core.pojo.entity.*;
import org.shanzhaozhen.gbpmn.core.service.IProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final ProcessDiagramTemplateMapper processDiagramTemplateMapper;

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

        // todo: 将节点发送到队列中
//        ProcessQueue processQueue = null;
//        processQueue.pushQueue(processRuntime.getId());
    }
}
