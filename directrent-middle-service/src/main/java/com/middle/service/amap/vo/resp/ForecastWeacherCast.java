package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.Date;

/**
 * @description: 预报天气数据list结构，元素cast
 * @author: YX
 * @date: 2020/9/23 10:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ForecastWeacherCast {

    /**
     * 日期
     */
    private Date date;
    /**
     * 星期几
     */
    private int week;
    /**
     * 白天天气现象
     */
    private String dayweather;
    /**
     * 晚上天气现象
     */
    private String nightweather;
    /**
     * 白天温度
     */
    private int daytemp;
    /**
     * 晚上温度
     */
    private int nighttemp;
    /**
     * 白天风向
     */
    private String daywind;
    /**
     * 晚上风向
     */
    private String nightwind;
    /**
     * 白天风力
     */
    private String daypower;
    /**
     * 晚上风力
     */
    private String nightpower;
}