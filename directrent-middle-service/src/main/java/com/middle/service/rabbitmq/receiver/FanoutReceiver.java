package com.middle.service.rabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 15:30
 */
public class FanoutReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receive2(String in) throws InterruptedException {
        receive(in, 2);
    }

    private void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [x] Received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        LOGGER.info("instance {} [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}