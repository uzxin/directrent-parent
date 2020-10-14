package com.middle.service.rabbitmq.config;

import com.middle.service.rabbitmq.receiver.FanoutReceiver;
import com.middle.service.rabbitmq.sender.FanoutSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 发布订阅模式
 * 发布/订阅模式是指同时向多个消费者发送消息的模式（类似广播的形式），
 * 它包含一个生产者、两个消费者、两个队列和一个交换机。
 * 两个消费者同时绑定到不同的队列上去，两个队列绑定到交换机上去，
 * 生产者通过发送消息到交换机，所有消费者接收并消费消息。
 * @author: YX
 * @date: 2020/10/14 15:28
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     * 交换机
     */
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("exchange.fanout");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue fanoutQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanout, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanout);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanout, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanout);
    }

    @Bean
    public FanoutReceiver fanoutReceiver() {
        return new FanoutReceiver();
    }

    @Bean
    public FanoutSender fanoutSender() {
        return new FanoutSender();
    }

}