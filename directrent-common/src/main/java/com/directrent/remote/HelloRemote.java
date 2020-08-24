package com.directrent.remote;

import com.directrent.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 15:24
 * @copyright:
 * @version: 1.0
 * @description:
 */
@FeignClient(name = "directrent-api", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @GetMapping("hello")
    String hello(@RequestParam(name = "name") String name);

}
