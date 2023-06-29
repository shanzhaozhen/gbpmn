package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.constant.ProcessActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;


/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 提交申请单
 */
public class OperatorOfApprovalApply implements IOperator {

    private static final ProcessActionType type = ProcessActionType.LAUNCH;

    public static int price = 500;

    @Override
    public ProcessActionType getType() {
        return type;
    }

    @Override
    public void doTask(ProcessEngine processEngine, GNode node, GContext gContext) {
        //price每次减100
        gContext.putValue("price", price -= 100);
        gContext.putValue("applicant", "小张");

        processEngine.nodeFinished(node.onlyOneOut());
    }

}
