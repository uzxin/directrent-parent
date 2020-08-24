package com.directrent.system.service.impl;

import com.directrent.system.entity.SysUser;
import com.directrent.system.mapper.SysUserMapper;
import com.directrent.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 14:14
 * @copyright:
 * @version: 1.0
 * @description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> listAll() {
        return sysUserMapper.listAll();
    }
}