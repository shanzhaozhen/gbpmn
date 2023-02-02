package org.shanzhaozhen.gbpmn.core.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-02
 * @Description:
 */
@Configuration
public class RabbitGbpmnConfig {

    private String queueName = "TestDirectQueue";
    private String exchangeKey = "TestDirectExchange";
    private String routingKey = "TestDirectRouting";

    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue() {
        return new Queue(queueName,true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange(exchangeKey);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with(routingKey);
    }

}
