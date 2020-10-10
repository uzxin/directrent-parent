package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 地理编码信息
 * @author: YX
 * @date: 2020/10/10 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Geocode {

    /**
     * 结构化地址信息
     * 省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
     */
    private String formatted_address;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 城市编码
     */
    private String citycode;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 门牌
     */
    private String number;
    /**
     * 区域编码
     */
    private String adcode;
    /**
     * 坐标点
     */
    private String location;
    /**
     * 匹配级别
     */
    private String level;
}