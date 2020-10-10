package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 经纬度所属商圈
 * @author: YX
 * @date: 2020/10/10 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BusinessAreas {

    /**
     * 商圈信息
     */
    private String businessArea;
    /**
     * 商圈中心点经纬度
     */
    private String location;
    /**
     * 商圈名称
     */
    private String name;
    /**
     * 商圈所在区域的adcode
     */
    private String id;
}