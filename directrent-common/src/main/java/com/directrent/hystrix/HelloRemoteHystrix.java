package com.directrent.hystrix;

import com.directrent.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 16:01
 * @copyright:
 * @version: 1.0
 * @description:
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(name = "name") String name) {
        return "服务调用失败，进入熔断器:"+name;
    }
}