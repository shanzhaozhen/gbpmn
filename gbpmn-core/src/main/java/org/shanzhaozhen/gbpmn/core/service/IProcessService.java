package org.shanzhaozhen.gbpmn.core.service;

import org.shanzhaozhen.gbpmn.core.pojo.entity.GProcess;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessAction;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessInstance;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessRuntime;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
public interface IProcessService {

    /**
     * 创建流程实例
     * @param processInstance
     */
    void addProcess(ProcessInstance processInstance);

    /**
     * 审批流程
     */
    void approvalProcess(ProcessAction processAction);

    /**
     * 获取流程图
     * @param processRuntime
     * @return
     */
    GProcess getProcessDiagram(ProcessRuntime processRuntime);


}
