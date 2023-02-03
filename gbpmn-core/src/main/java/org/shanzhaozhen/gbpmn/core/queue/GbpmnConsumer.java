package org.shanzhaozhen.gbpmn.core.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-02
 * @Description:
 */
@Component
@RabbitListener(queues = "${rabbitmq.gbpmn.queueName}")     //监听的队列名称
@Slf4j
public class GbpmnConsumer {

    @RabbitHandler
    public void process(String msg) {
        log.info("消费者收到消息  : " + msg);
    }

}
