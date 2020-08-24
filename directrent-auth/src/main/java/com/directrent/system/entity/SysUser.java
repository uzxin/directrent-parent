package com.directrent.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: directrent-parent
 * @author: YX
 * @date: 2020/7/29 14:00
 * @copyright:
 * @version: 1.0
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

    private Integer id;

    private String username;

    private String password;
}