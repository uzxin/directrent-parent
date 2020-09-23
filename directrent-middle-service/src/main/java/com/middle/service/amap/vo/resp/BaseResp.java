package com.middle.service.amap.vo.resp;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: YX
 * @date: 2020/9/23 10:23
 */
@Data
@ToString
public class BaseResp implements Serializable {
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
}