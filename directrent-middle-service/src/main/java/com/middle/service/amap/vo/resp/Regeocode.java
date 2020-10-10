package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 逆地理编码
 * @author: YX
 * @date: 2020/10/10 15:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Regeocode {

    /**
     * 结构化地址信息
     * 结构化地址信息包括：省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
     * 如果坐标点处于海域范围内，则结构化地址信息为：省份＋城市＋区县＋海域信息
     */
    private String formatted_address;
    /**
     * 地址元素列表
     */
    private AddressComponent addressComponent;
    /**
     * 道路信息列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    private List<Road> roads;
    /**
     * 道路交叉口列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    private List<Roadinter> roadinters;
    /**
     * poi信息列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    private List<Poi> pois;
    /**
     * aoi信息列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    private List<Aoi> aois;
}