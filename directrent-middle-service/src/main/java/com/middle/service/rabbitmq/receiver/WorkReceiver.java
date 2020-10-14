package com.middle.service.rabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 15:15
 */
@RabbitListener(queues = "work.hello")
public class WorkReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkReceiver.class);

    private final int instance;

    public WorkReceiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        //计时器
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("receiver {}  Received '{}'", this.instance, in);
        doWork(in);
        watch.stop();
        LOGGER.info("receiver {} 完成任务，花费了{}s", this.instance, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}