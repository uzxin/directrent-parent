package com.middle.service.mqtt.controller;

import com.middle.service.mqtt.config.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/14 17:13
 */
@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/sendToDefaultTopic")
    public Object sendToDefaultTopic(String payload) {
        mqttGateway.sendToMqtt(payload);
        return "OK";
    }

    @PostMapping("/sendToTopic")
    public Object sendToTopic(String payload, String topic) {
        mqttGateway.sendToMqtt(payload, topic);
        return "OK";
    }
}