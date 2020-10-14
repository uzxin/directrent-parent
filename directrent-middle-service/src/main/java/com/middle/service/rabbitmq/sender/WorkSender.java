package com.middle.service.rabbitmq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 15:15
 */
public class WorkSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkSender.class);

    @Autowired
    private RabbitTemplate template;

    private static final String queueName = "work.hello";

    public void send(int index) {
        StringBuilder builder = new StringBuilder("任务");
        builder.append(index+1);
        String message = builder.toString();
        template.convertAndSend(queueName, message);
        LOGGER.info(" sender 发布了 '{}'", message);
    }
}