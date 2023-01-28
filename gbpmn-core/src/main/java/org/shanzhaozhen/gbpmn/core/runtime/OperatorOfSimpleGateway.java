package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.pojo.constant.FlowActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GEdge;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 简单是非判断
 */
public class OperatorOfSimpleGateway implements IOperator {
    @Override
    public FlowActionType getType() {
        return FlowActionType.AGREE;
    }

    @Override
    public void doTask(ProcessEngine processEngine, GNode node, GContext gContext) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("approvalResult", gContext.getValue("approvalResult"));

//        String expression = XmlUtil.childTextByName(node.xmlNode, "expr");
//        String trueOutGoingEdgeID = XmlUtil.childTextByName(node.xmlNode, "trueOutGoing");

        String expression = "";
        String trueOutGoingEdgeID = "";

        GEdge outPeEdge = null;
        try {
            outPeEdge = (Boolean) engine.eval(expression) ?
                    node.outWithID(trueOutGoingEdgeID) : node.outWithOutID(trueOutGoingEdgeID);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        processEngine.nodeFinished(outPeEdge);
    }
}
