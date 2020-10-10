package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 道路交叉口
 * @author: YX
 * @date: 2020/10/10 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Roadinter {

    /**
     * 交叉路口到请求坐标的距离,单位：米
     */
    private String distance;
    /**
     * 方位
     */
    private String direction;
    /**
     * 路口经纬度
     */
    private String location;
    /**
     * 第一条道路id
     */
    private String first_id;
    /**
     * 第一条道路名称
     */
    private String first_name;
    /**
     * 第二条道路id
     */
    private String second_id;
    /**
     * 第二条道路名称
     */
    private String second_name;
}