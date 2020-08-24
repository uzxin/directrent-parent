package com.directrent.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 11:49
 * @copyright:
 * @version: 1.0
 * @description: druid配置
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>( new StatViewServlet(), "/druid/*" );

        Map<String,String> iniParms=new HashMap<>(  );

        iniParms.put( "loginUsername","admin" );//登录druid的用户名
        iniParms.put( "loginPassword","admin" );//登录druid的密码
        iniParms.put("allow","");//默认允许所有
        iniParms.put( "deny","192.168.***.***" );//自己本机的ip地址
        bean.setInitParameters( iniParms );
        return bean;

    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean= new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> iniParms=new HashMap<>();
        iniParms.put( "excliusions", "*.js,*.css,/druid/*");//使静态文件访问，还有/druid/* 的访问不被拦截
        bean.setInitParameters( iniParms );
        bean.setUrlPatterns( Arrays.asList("/*"));
        return bean;
    }
}