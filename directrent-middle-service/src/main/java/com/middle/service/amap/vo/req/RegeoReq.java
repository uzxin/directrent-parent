package com.middle.service.amap.vo.req;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @description: 逆地理编码请求对象
 * @author: YX
 * @date: 2020/10/10 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RegeoReq extends BaseReq {

    /**
     * 经纬度坐标(必填)
     * 经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位
     * 如果需要解析多个经纬度的话，请用"|"进行间隔，并且将 batch 参数设置为 true
     * 最多支持传入 20 对坐标点。每对点坐标之间用"|"分割
     */
    @NotNull(message = "经纬度坐标不能为空")
    private String location;
    /**
     * 返回附近POI类型(选填)
     * 以下内容需要 extensions 参数为 all 时才生效。
     * 逆地理编码在进行坐标解析之后不仅可以返回地址描述，也可以返回经纬度附近符合限定要求的POI内容（在 extensions 字段值为 all 时才会返回POI内容）
     * 设置 POI 类型参数相当于为上述操作限定要求。参数仅支持传入POI TYPECODE，可以传入多个POI TYPECODE，相互之间用“|”分隔
     * 该参数在 batch 取值为 true 时不生效。获取 POI TYPECODE 可以参考POI分类码表
     */
    private String poitype;
    /**
     * 搜索半径(选填),默认是1000。单位：米
     * radius取值范围在0~3000
     */
    private int radius;
    /**
     * 返回结果控制(选填)
     * extensions 参数默认取值是 base，也就是返回基本地址信息；
     * extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
     */
    private String extensions;
    /**
     * 批量查询控制(选填),默认为false
     * batch 参数设置为 true 时进行批量查询操作，最多支持 20 个经纬度点进行批量地址查询操作。
     * batch 参数设置为 false 时进行单点查询，此时即使传入多个经纬度也只返回第一个经纬度的地址解析查询结果。
     */
    private Boolean batch;
    /**
     * 道路等级(选填)，可选值：0，1
     * 以下内容需要 extensions 参数为 all 时才生效。
     * 当roadlevel=0时，显示所有道路
     * 当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
     */
    private int roadlevel;
    /**
     * 数字签名(选填)
     */
    private String sig;
    /**
     * 回调函数(选填)
     * 此参数只在 output 参数设置为 JSON 时有效。
     */
    private String callback;
    /**
     * 是否优化POI返回顺序(选填)
     * 以下内容需要 extensions 参数为 all 时才生效。
     * homeorcorp 参数的设置可以影响召回 POI 内容的排序策略，目前提供三个可选参数：
     * 0：不对召回的排序策略进行干扰。
     * 1：综合大数据分析将居家相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     * 2：综合大数据分析将公司相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     */
    private int homeorcorp;
}