package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 地理编码接口返回对象
 * @author: YX
 * @date: 2020/10/10 15:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GeoResp extends BaseResp {

    /**
     * 地理编码信息列表
     */
    private List<Geocode> geocodes;
}