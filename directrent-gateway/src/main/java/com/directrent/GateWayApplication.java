package com.directrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 16:26
 * @copyright:
 * @version: 1.0
 * @description:
 */
@SpringBootApplication
@Slf4j
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
        log.info("gateway模块启动成功");
    }

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/about")
                        .uri("http://ityouknow.com"))
                .build();
    }*/
}