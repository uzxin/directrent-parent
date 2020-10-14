package com.middle.service.rabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 14:15
 */
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(String in) {
        LOGGER.info(" [x] Received '{}'", in);
    }
}