package com.middle.service.amap.vo.req;

import lombok.*;

/**
 * @description: IP定位请求对象
 * @author: YX
 * @date: 2020/9/22 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IPconfigReq extends BaseReq {
    /**
     * ip地址(选填)
     */
    private String ip;
    /**
     * 签名(选填)，选择数字签名认证的付费用户必填
     */
    private String sig;
}