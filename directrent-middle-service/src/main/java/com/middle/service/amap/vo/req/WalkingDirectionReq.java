package com.middle.service.amap.vo.req;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @description: 路径规划（步行）请求对象
 * @author: YX
 * @date: 2020/10/10 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WalkingDirectionReq extends BaseReq {

    /**
     * 出发点(必填)
     * 规则： lon，lat（经度，纬度）， “,”分割，如117.500244, 40.417801     经纬度小数点不超过6位
     */
    @NotNull(message = "出发点不能为空")
    private String origin;
    /**
     * 目的地(必填)
     * 规则： lon，lat（经度，纬度）， “,”分割，如117.500244, 40.417801     经纬度小数点不超过6位
     */
    @NotNull(message = "目的地不能为空")
    private String destination;
    /**
     * 数字签名(选填)
     */
    private String sig;
    /**
     * 回调函数(选填)
     * 此参数只在output=JSON时有效
     */
    private String callback;
}