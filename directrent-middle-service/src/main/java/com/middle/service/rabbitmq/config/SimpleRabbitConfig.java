package com.middle.service.rabbitmq.config;

import com.middle.service.rabbitmq.receiver.SimpleReceiver;
import com.middle.service.rabbitmq.sender.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 简单模式
 * 简单模式是最简单的消息模式，
 * 它包含一个生产者、一个消费者和一个队列。
 * 生产者向队列里发送消息，消费者从队列中获取消息并消费。
 * @author: YX
 * @date: 2020/10/14 14:13
 */
@Configuration
public class SimpleRabbitConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue("simple.hello");
    }

    @Bean
    public SimpleSender simpleSender(){
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }
}