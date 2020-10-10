package com.middle.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 中台服务模块启动类
 * @author: YX
 * @date: 2020/8/26 0026 21:44
 */

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class MiddleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddleServiceApplication.class, args);
        log.info("中台服务模块启动成功");
    }
}