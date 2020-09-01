package com.directrent.common.config.applicaition;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @description: 项目启动时测试数据库连接是否正常
 * @author: YX
 * @date: 2020/8/27 0027 22:25
 */
@Component
@Slf4j
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            context = applicationContext;
            // ===== 在项目初始化bean后检验数据库连接是否
            DataSource dataSource = (DataSource) context.getBean("dataSource");
            dataSource.getConnection().close();
            log.info("数据库连接正常");
        } catch (Exception e) {
            // ===== 当检测数据库连接失败时, 停止项目启动
            log.error("数据库连接失败，{}", e.toString());
        }
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

}