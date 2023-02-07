package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.constant.ProcessActionType;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 算子
 */
public interface IOperator {

    // 引擎可以据此来找到本算子
    ProcessActionType getType();

    // 引擎调度本算子
    void doTask(ProcessEngine processEngine, GNode node, GContext gContext);

}
