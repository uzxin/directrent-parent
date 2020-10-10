package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 门牌信息列表
 * @author: YX
 * @date: 2020/10/10 15:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StreetNumber {

    /**
     * 街道名称
     */
    private String street;
    /**
     * 门牌号
     */
    private String number;
    /**
     * 坐标点
     */
    private String location;
    /**
     * 方向
     */
    private String direction;
    /**
     * 门牌地址到请求坐标的距离,单位：米
     */
    private String distance;
}