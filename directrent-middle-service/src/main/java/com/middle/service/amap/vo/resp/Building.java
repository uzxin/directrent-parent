package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 楼信息
 * @author: YX
 * @date: 2020/10/10 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Building {

    /**
     * 建筑名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
}