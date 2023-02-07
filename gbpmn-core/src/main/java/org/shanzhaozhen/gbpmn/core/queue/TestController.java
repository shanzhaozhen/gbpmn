package org.shanzhaozhen.gbpmn.core.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-03
 * @Description:
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final GbpmnProducer gbpmnProducer;

    @GetMapping("/test/rabbit/{msg}")
    public void test(@PathVariable String msg) {
        gbpmnProducer.pushQueue(msg);
    }

}
