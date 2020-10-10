package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: poi信息
 * @author: YX
 * @date: 2020/10/10 16:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Poi {

    /**
     * poi的id
     */
    private String id;
    /**
     * poi点名称
     */
    private String name;
    /**
     * poi类型
     */
    private String type;
    /**
     * 电话
     */
    private String tel;
    /**
     * 该POI的中心点到请求坐标的距离，单位：米
     */
    private String distance;
    /**
     * 方向
     */
    private String direction;
    /**
     * poi地址信息
     */
    private String address;
    /**
     * 坐标点
     */
    private String location;
    /**
     * poi所在商圈名称
     */
    private String businessarea;
}