package com.middle.service.amap.vo.req;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: YX
 * @date: 2020/9/23 10:18
 */
@Data
@ToString
public class BaseReq implements Serializable {

    /**
     * 请求服务权限标识(必填)
     */
    @NotNull(message = "key不能为空")
    private String key;
    /**
     * 返回格式(选填)，JSON或者XML，默认为JSON
     */
    private String output;

}