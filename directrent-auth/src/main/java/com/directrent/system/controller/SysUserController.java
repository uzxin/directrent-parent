package com.directrent.system.controller;

import com.directrent.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 14:16
 * @copyright:
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("system")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("user")
    public Object listUser(){
        return sysUserService.listAll();
    }
}