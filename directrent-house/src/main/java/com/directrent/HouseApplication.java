package com.directrent;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 房屋信息模块启动类
 * @author: YX
 * @date: 2020/8/26 0026 21:44
 */

@SpringBootApplication
@MapperScan("com.directrent.**.dao")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//SpringCloud中使用断路器，需要加上此注解
@EnableSwagger2//开启swagger文档
@Slf4j
public class HouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
        log.info("房屋信息模块启动成功");
    }
}