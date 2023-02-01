package org.shanzhaozhen.gbpmn.core.queue;

import java.util.List;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-30
 * @Description: 流程队列
 */
public interface ProcessQueue {

    /**
     * 入队
     * @param processRuntimeId
     */
    void pushQueue(String processRuntimeId);

    /**
     * 出队
     * @return
     */
    String popQueue();

    /**
     * 显示队列
     * @return
     */
    List<String> showQueue();

}
