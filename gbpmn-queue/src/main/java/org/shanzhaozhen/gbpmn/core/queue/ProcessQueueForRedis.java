package org.shanzhaozhen.gbpmn.core.queue;

import java.util.List;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-30
 * @Description:
 */
public class ProcessQueueForRedis implements ProcessQueue {

    @Override
    public void pushQueue(String processRuntimeId) {

    }

    @Override
    public String popQueue() {
        return null;
    }

    @Override
    public List<String> showQueue() {
        return null;
    }

}
