package com.middle.service.amap.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description: IP定位返回对象
 * @author: YX
 * @date: 2020/9/22 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IPconfigResp {

    /**
     * 返回结果状态值,0-失败，1-成功
     */
    private int status;
    /**
     * 返回状态说明，成功时返回OK，失败时返回错误原因
     */
    private String info;
    /**
     * 状态码，详情参阅info状态表
     */
    private String infocode;
    /**
     * 省份名称
     * 若为直辖市则显示直辖市名称；
     * 如果在局域网 IP网段内，则返回“局域网”；
     * 非法IP以及国外IP则返回空
     */
    private String province;
    /**
     * 城市名称
     * 若为直辖市则显示直辖市名称；
     * 如果为局域网网段内IP或者非法IP或国外IP，则返回空
     */
    private String city;
    /**
     * 城市的adcode编码，参照城市编码表
     */
    private String adcode;
    /**
     * 所在城市矩形区域范围，所在城市范围的左下右上对标对
     */
    private String rectangle;
}