package com.directrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 14:27
 * @copyright:
 * @version: 1.0
 * @description: 注册中心启动类
 */

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        log.info("eureka启动成功");
    }
}