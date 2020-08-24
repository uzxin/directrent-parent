package com.directrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 16:37
 * @copyright:
 * @version: 1.0
 * @description: 权限模块启动类
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        log.info("auth模块启动成功");
    }
}