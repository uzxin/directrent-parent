package com.middle.service.amap.vo.req;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @description: 天气查询请求对象
 * @author: YX
 * @date: 2020/9/23 09:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeatherInfoReq extends BaseReq{
    /**
     * 城市编码(必填),参照城市编码表
     */
    @NotNull(message = "城市编码不能为空")
    private String city;
    /**
     * 气象类型(选填)，base-返回实况天气all-返回预报天气，默认为base
     */
    private String extensions;
    /**
     * 返回格式(选填)，JSON或者XML
     */
    private String output;
}