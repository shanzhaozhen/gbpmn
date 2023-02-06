package org.shanzhaozhen.gbpmn.core.queue;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-02
 * @Description:
 */
@Configuration
@Getter
public class GbpmnQueueConfig {

    @Value("${rabbitmq.gbpmn.queueName}")
    private String queueName;
    @Value("${rabbitmq.gbpmn.exchangeKey}")
    private String exchangeKey;
    @Value("${rabbitmq.gbpmn.routingKey}")
    private String routingKey;

    /**
     * 声明队列名
     * @return
     */
    @Bean
    public Queue gbpmnQueue() {
        return new Queue(queueName,true);
    }

    //Direct交换机 起名：TestDirectExchange

    /**
     * 声明 direct 路由模式的交换机
     * @return
     */
    @Bean
    DirectExchange gbpmnExchange() {
        return new DirectExchange(exchangeKey);
    }

    /**
     * 绑定交换机与队列的关系
     * @return
     */
    @Bean
    Binding gbpmnBinding() {
        return BindingBuilder.bind(gbpmnQueue()).to(gbpmnExchange()).with(routingKey);
    }

}
