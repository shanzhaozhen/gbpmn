package org.shanzhaozhen.gbpmn.core.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shanzhaozhen.gbpmn.core.constant.RuntimeStatus;
import org.shanzhaozhen.gbpmn.core.mapper.ProcessRuntimeMapper;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessRuntime;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-02
 * @Description:
 */
@Component
@RabbitListener(queues = "${rabbitmq.gbpmn.queueName}")     //监听的队列名称
@RequiredArgsConstructor
@Slf4j
public class GbpmnConsumer {

    private final ProcessRuntimeMapper processRuntimeMapper;

    @RabbitHandler
    public void process(String processRuntimeId) {
        log.info("流程队列出队，流程ID: {}", processRuntimeId);
        ProcessRuntime processRuntime = processRuntimeMapper.selectById(processRuntimeId);
        try {
            Assert.notNull(processRuntime, "没有获取到指定运行时流程");

            // TODO: 2023-2-6 获取当前流程运行节点


            // TODO: 2023-2-6 检查流程是否有下一节点，有则入队

        } catch (Exception e) {
            log.info("流程执行异常，流程ID: {}，异常：{}", processRuntimeId, e);
            processRuntime.setStatus(RuntimeStatus.ERROR.getCode());
            processRuntimeMapper.updateById(processRuntime);
        }

    }

}
