package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 道路信息
 * @author: YX
 * @date: 2020/10/10 16:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Road {

    /**
     * 道路id
     */
    private String id;
    /**
     * 道路名称
     */
    private String name;
    /**
     * 道路到请求坐标的距离,单位：米
     */
    private String distance;
    /**
     * 方位
     */
    private String direction;
    /**
     * 坐标点
     */
    private String location;
}