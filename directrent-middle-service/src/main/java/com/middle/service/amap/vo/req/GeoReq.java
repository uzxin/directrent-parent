package com.middle.service.amap.vo.req;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @description: 地理编码请求对象
 * @author: YX
 * @date: 2020/10/10 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GeoReq extends BaseReq {

    /**
     * 结构化地址信息(必填)
     * 规则遵循：国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦
     * 如：北京市朝阳区阜通东大街6号
     * 如果需要解析多个地址的话，请用"|"进行间隔，并且将 batch 参数设置为 true
     * 最多支持 10 个地址进进行"|"分割形式的请求
     */
    @NotNull(message = "结构化地址信息不能为空")
    private String address;
    /**
     * 指定查询的城市(选填)
     * 可选输入内容包括：指定城市的中文（如北京）、指定城市的中文全拼（beijing）、citycode（010）、adcode（110000），不支持县级市。
     * 当指定城市查询内容为空时，会进行全国范围内的地址转换检索
     * adcode信息可参考城市编码表获取
     */
    private String city;
    /**
     * 批量查询控制(选填),默认为false
     * batch 参数设置为 true 时进行批量查询操作，最多支持 10 个地址进行批量查询。
     * batch 参数设置为 false 时进行单点查询，此时即使传入多个地址也只返回第一个地址的解析查询结果。
     */
    private Boolean batch;
    /**
     * 数字签名(选填)
     */
    private String sig;
    /**
     * 回调函数(选填)
     * callback 值是用户定义的函数名称，此参数只在 output 参数设置为 JSON 时有效。
     */
    private String callback;
}