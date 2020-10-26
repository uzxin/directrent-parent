package com.directrent.common.config.applicaition;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import sun.java2d.cmm.Profile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class PrefixLogConfig extends ClassicConverter {
    private static String IP;
    private static String applicationName;
    private static String logPrefix;

    public String getApplicationName() {
        return applicationName;
    }

    static {
        Properties props = new Properties();
        InputStream in = null;
        try{
            IP = InetAddress.getLocalHost().getHostAddress();
            //in = PrefixLogConfig.class.getResourceAsStream("/application.properties");
            in = PrefixLogConfig.class.getResourceAsStream("/application.yml");
            props.load(in);
            //applicationName = props.getProperty("spring.application.name");
            applicationName = props.getProperty("name");
            logPrefix=IP+" "+applicationName;
            log.info("完成LogIpConfig初始化,加载properties文件内容完成...........");

        }catch (UnknownHostException e){
            log.error("LogIpConfig初始化时,无法获取HOST",e);
        } catch (FileNotFoundException e) {
            log.error("LogIpConfig初始化时,application.properties文件未找到");
        } catch (IOException e) {
            log.error("LogIpConfig初始化时,出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("LogIpConfig初始化时,application.properties文件流关闭出现异常");
            }
        }
    }


    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return logPrefix;
    }

}
