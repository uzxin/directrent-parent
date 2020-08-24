package com.directrent.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 15:03
 * @copyright:
 * @version: 1.0
 * @description:
 */
@Controller
@RequestMapping("redis")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("test")
    public Object test(){
        return redisTemplate.opsForValue().get("name");
    }
}