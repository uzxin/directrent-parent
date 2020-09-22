package com.middle.service.amap.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @description: IP定位请求对象
 * @author: YX
 * @date: 2020/9/22 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IPconfigReq {

    /**
     * 请求服务权限标识(必填)
     */
    @NotNull(message = "key不能为空")
    private String key;
    /**
     * ip地址(选填)
     */
    private String ip;
    /**
     * 签名(选填)，选择数字签名认证的付费用户必填
     */
    private String sig;
    /**
     * 返回格式(选填)，JSON或者XML，默认为JSON
     */
    private String output;
}