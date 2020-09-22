package com.middle.service.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: http请求返回对象
 * @author: YX
 * @date: 2020/9/22 16:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int code){
        this.code = code;
    }

}