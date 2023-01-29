package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.builder.GProcessBuilder;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GContext;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GEdge;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GProcess;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessEngine {

    //存储算子
    private Map<String, IOperator> type2Operator = new ConcurrentHashMap<>();
    private GProcess gProcess = null;
    private GContext gContext = null;

    //任务数据暂存
    public final BlockingQueue<GNode> arrayBlockingQueue = new LinkedBlockingQueue();

    //任务调度线程
    public final Thread dispatchThread = new Thread(() -> {
        while (true) {
            try {
                GNode node = arrayBlockingQueue.take();
                type2Operator.get(node.getType()).doTask(this, node, gContext);
            } catch (Exception e) {
            }
        }
    });

    //算子注册到引擎中，便于引擎调用之
    public void registNodeProcessor(IOperator operator) {
        type2Operator.put(operator.getType().getName(), operator);
    }

    public void start() throws Exception {
        gProcess = GProcessBuilder.build();
        gContext = new GContext();

        dispatchThread.setDaemon(true);
        dispatchThread.start();

        executeNode(gProcess.getStart().onlyOneOut().getTarget());
    }

    private void executeNode(GNode node) {
        if (!node.getType().equals("endEvent")) {
            arrayBlockingQueue.add(node);
        } else {
            System.out.println("process finished!");
        }
    }

    public void nodeFinished(GEdge nextPeEdgeID) {
        executeNode(nextPeEdgeID.getSource());
    }

}
