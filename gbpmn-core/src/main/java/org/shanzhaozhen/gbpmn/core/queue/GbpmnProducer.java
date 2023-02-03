package org.shanzhaozhen.gbpmn.core.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-03
 * @Description:
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class GbpmnProducer {

    private final RabbitTemplate rabbitTemplate;

    private final RabbitGbpmnConfig rabbitGbpmnConfig;

    public void send(String msg) {
        log.info("生产者发送队列：" + msg);
        //指定交换机和路由键可以知道绑定的queue, 根据第二个参数完全匹配
        rabbitTemplate.convertAndSend(rabbitGbpmnConfig.getRoutingKey(), msg);
    }

}
