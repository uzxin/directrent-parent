package com.directrent.common.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @description: swagger基础配置
 * @author: YX
 * @date: 2020/9/17 17:10
 * 默认访问路径为http://localhost:8001/swagger-ui.html
 */
@Configuration
public class BaseConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("房源信息模块")
                .apiInfo(getApiInfo())
                // .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                // .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .apis(RequestHandlerSelectors.basePackage("com.directrent.house")) //过滤的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("uzxin","https://github.com/uzxin", "1258971228@qq.com");
        return new ApiInfoBuilder()
                .title("directrent-house模块") // 标题
                .description("主要是跟房源相关的系列接口") // 描述信息
                .version("0.0.1") // //版本
                .license("uzxin")
                .licenseUrl("http://www.uzxin.top")
                .contact(contact)
                .build();
    }
}