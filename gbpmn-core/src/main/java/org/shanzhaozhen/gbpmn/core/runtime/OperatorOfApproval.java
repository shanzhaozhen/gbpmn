package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.pojo.constant.FlowActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;


/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 审批
 */
public class OperatorOfApproval implements IOperator {

    @Override
    public FlowActionType getType() {
        return FlowActionType.AGREE;
    }

    @Override
    public void doTask(ProcessEngine processEngine, GNode node, GContext gContext) {
        gContext.putValue("approver", "经理");

        Integer price = (Integer) gContext.getValue("price");
        //价格<=200审批才通过，即：approvalResult=true
        boolean approvalResult = price <= 200;
        gContext.putValue("approvalResult", approvalResult);

        System.out.println("approvalResult ： " + approvalResult + "，price : " + price);

        processEngine.nodeFinished(node.onlyOneOut());
    }

}
