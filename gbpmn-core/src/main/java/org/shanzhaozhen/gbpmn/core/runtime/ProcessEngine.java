package org.shanzhaozhen.gbpmn.core.runtime;

import org.shanzhaozhen.gbpmn.core.builder.GProcessBuilder;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GNode;
import org.shanzhaozhen.gbpmn.core.pojo.entity.GProcess;

public class ProcessEngine {


    public void run() throws Exception {
        GProcess gProcess = GProcessBuilder.build();

        GNode node = gProcess.start;

        while (!node.type.equals("endEvent")) {
            if ("printHello".equals(node.type))
                System.out.print("Hello ");
            if ("printProcessEngine".equals(node.type))
                System.out.print("ProcessEngine ");

            node = node.out.to;
        }
    }

}
