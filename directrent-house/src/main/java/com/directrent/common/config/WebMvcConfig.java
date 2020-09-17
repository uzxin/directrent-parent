package com.directrent.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @description: web配置类
 * @author: YX
 * @date: 2020/8/26 22:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }

    /**
     * 配置静态资源路径
     * 也可以在如在application.yml中就配置如下:
     * spring:
     *   resources:
     *     static-locations: classpath:/static/
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 视图映射
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/client/index.html");
        registry.addViewController("/index").setViewName("redirect:/client/index.html");
        registry.addViewController("/back").setViewName("redirect:/index.html");
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 通过registry来注册拦截器，通过addPathPatterns来添加拦截路径
        /*registry.addInterceptor(this.userInterceptor).addPathPatterns("/shoppingcart/**").addPathPatterns("/user/person/index.html")
                .addPathPatterns("/user/home/shopcart.html");

        registry.addInterceptor(this.adminInterceptor).addPathPatterns("/admin/index.html");*/
    }
}
