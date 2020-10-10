package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: aoi信息
 * @author: YX
 * @date: 2020/10/10 16:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Aoi {

    /**
     * aoi的id
     */
    private String id;
    /**
     * aoi点名称
     */
    private String name;
    /**
     * 所属 aoi 所在区域编码
     */
    private String adcode;
    /**
     * 所属 aoi 中心点坐标
     */
    private String location;
    /**
     * 所属aoi点面积，单位：平方米
     */
    private String area;
    /**
     * 输入经纬度是否在aoi面之中
     * 0，代表在aoi内，其余整数代表距离AOI的距离
     */
    private String distance;
}