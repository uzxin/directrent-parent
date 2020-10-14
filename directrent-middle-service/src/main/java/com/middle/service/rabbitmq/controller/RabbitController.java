package com.middle.service.rabbitmq.controller;

import com.middle.service.rabbitmq.sender.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 14:17
 */
@Controller
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;
    @Autowired
    private WorkSender workSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    @ResponseBody
    public Object simpleTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            simpleSender.send();
            Thread.sleep(1000);
        }
        return "ok";
    }

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    @ResponseBody
    public Object workTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            workSender.send(i);
            Thread.sleep(1000);
        }
        return "ok";
    }

    @RequestMapping(value = "/fanout", method = RequestMethod.GET)
    @ResponseBody
    public Object fanoutTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            fanoutSender.send(i);
            Thread.sleep(1000);
        }
        return "OK";
    }

    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    @ResponseBody
    public Object directTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            directSender.send(i);
            Thread.sleep(1000);
        }
        return "OK";
    }

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    @ResponseBody
    public Object topicTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            topicSender.send(i);
            Thread.sleep(1000);
        }
        return "OK";
    }

}