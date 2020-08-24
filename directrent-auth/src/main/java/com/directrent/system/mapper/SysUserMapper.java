package com.directrent.system.mapper;

import com.directrent.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 14:09
 * @copyright:
 * @version: 1.0
 * @description:
 */
@Mapper
public interface SysUserMapper {

    List<SysUser> listAll();
}
