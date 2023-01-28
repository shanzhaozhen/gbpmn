package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.pojo.constant.FlowActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;


/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 通知
 */
public class OperatorOfNotify implements IOperator {
    @Override
    public FlowActionType getType() {
        return FlowActionType.NOTIFY;
    }

    @Override
    public void doTask(ProcessEngine processEngine, GNode node, GContext gContext) {
        System.out.println(String.format("%s 提交的申请单 %s 被 %s 审批，结果为 %s",
                gContext.getValue("applicant"),
                gContext.getValue("price"),
                gContext.getValue("approver"),
                gContext.getValue("approvalResult")));

        processEngine.nodeFinished(node.onlyOneOut());
    }
}
