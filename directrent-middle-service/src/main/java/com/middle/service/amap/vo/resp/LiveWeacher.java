package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.Date;

/**
 * @description: 实况天气数据信息
 * @author: YX
 * @date: 2020/9/23 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LiveWeacher {

    /**
     * 省份名
     */
    private String province;
    /**
     * 城市名
     */
    private String city;
    /**
     * 区域编码
     */
    private String adcode;
    /**
     * 天气现象（汉字描述）
     */
    private String weather;
    /**
     * 实时气温，单位：摄氏度
     */
    private int temperature;
    /**
     * 风向描述
     */
    private String winddirection;
    /**
     * 风力级别，单位：级
     */
    private String windpower;
    /**
     * 空气湿度
     */
    private int humidity;
    /**
     * 数据发布的时间
     */
    private Date reporttime;
}