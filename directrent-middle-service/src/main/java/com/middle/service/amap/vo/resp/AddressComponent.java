package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 地址元素
 * @author: YX
 * @date: 2020/10/10 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressComponent {

    /**
     * 省
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
     * 行政区编码
     */
    private String adcode;
    /**
     * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）
     */
    private String township;
    /**
     * 乡镇街道编码
     */
    private String towncode;
    /**
     * 社区信息列表
     */
    private Neighborhood neighborhood;
    /**
     * 楼信息列表
     */
    private Building building;
    /**
     * 门牌信息列表
     */
    private StreetNumber streetNumber;
    /**
     * 所属海域信息
     */
    private String seaArea;
    /**
     * 经纬度所属商圈列表
     */
    private List<BusinessAreas> businessAreas;
}