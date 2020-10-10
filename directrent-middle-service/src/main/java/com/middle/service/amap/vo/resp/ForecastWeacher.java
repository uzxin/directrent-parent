package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @description: 预报天气信息数据
 * @author: YX
 * @date: 2020/9/23 10:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ForecastWeacher {

    /**
     * 城市名称
     */
    private String city;
    /**
     * 城市编码
     */
    private String adcode;
    /**
     * 省份名称
     */
    private String province;
    /**
     * 预报发布时间
     */
    private Date reporttime;
    /**
     * 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据
     */
    private List<ForecastWeacherCast> casts;
}