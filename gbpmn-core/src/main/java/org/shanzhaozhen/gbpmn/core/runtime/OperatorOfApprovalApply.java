package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.pojo.constant.FlowActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;


/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 提交申请单
 */
public class OperatorOfApprovalApply implements IOperator {

    public static int price = 500;

    @Override
    public FlowActionType getType() {
        return FlowActionType.LAUNCH;
    }

    @Override
    public void doTask(ProcessEngine processEngine, GNode node, GContext gContext) {
        //price每次减100
        gContext.putValue("price", price -= 100);
        gContext.putValue("applicant", "小张");

        processEngine.nodeFinished(node.onlyOneOut());
    }

}
