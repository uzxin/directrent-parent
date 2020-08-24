package com.directrent.controller;

import com.directrent.entity.User;
import com.directrent.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/28 15:34
 * @copyright:
 * @version: 1.0
 * @description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    @GetMapping("test")
    public String test(){
        return "测试成功";
    }

    @GetMapping("test1")
    public void test1(@RequestBody User user, HttpServletRequest request){
        Map<String, String[]> params = request.getParameterMap();
        System.out.println("=============");
        System.out.println(user);
        System.out.println(params == null);
        System.out.println(params.size());
        System.out.println(request.getParameter("username"));
        params.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(Arrays.toString(v));
        });
    }
}