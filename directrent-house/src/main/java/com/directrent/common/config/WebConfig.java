package com.directrent.common.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: web配置类
 * @author: YX
 * @date: 2020/8/26 0026 22:12
 */
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 配置静态资源路径
     * 也可以在如在application.yml中就配置如下:
     * spring:
     *   resources:
     *     static-locations: classpath:/static/
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}