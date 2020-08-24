package com.directrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 15:30
 * @copyright:
 * @version: 1.0
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class DataScrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataScrapApplication.class, args);
        log.info("dataScrap模块启动成功");
    }
}