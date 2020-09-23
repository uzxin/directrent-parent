package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 天气查询返回对象
 * @author: YX
 * @date: 2020/9/23 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeatherInfoResp extends BaseResp {

    /**
     * 返回结果总数目
     */
    private int count;
    /**
     * 实况天气数据信息
     */
    private List<LiveWeacher> lives;
    /**
     * 预报天气信息数据
     */
    private List<ForecastWeacher> forecasts;
}