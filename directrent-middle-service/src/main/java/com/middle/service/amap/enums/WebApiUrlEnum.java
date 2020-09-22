package com.middle.service.amap.enums;

import com.middle.service.amap.vo.req.IPconfigReq;
import com.middle.service.amap.vo.resp.IPconfigResp;

/**
 * @description: 高德地图web-api地址
 * @author: YX
 * @date: 2020/9/22 15:54
 */
public enum WebApiUrlEnum {

    /**
     * 根据ip地址获取地理位置
     */
    ipconfig("https://restapi.amap.com/v3/ip", "get", "https://restapi.amap.com/v3/ip?ip=114.247.50.2&output=xml&key=<用户的key>", IPconfigReq.class, IPconfigResp.class);

    /**
     * url地址
     */
    private String url;
    /**
     * 请求方式，get或者post
     */
    private String requestMethod;
    /**
     * 请求示例
     */
    private String example;
    /**
     * 请求参数对应类
     */
    private Class requestClass;
    /**
     * 返回值对应类
     */
    private Class responseClass;

    WebApiUrlEnum(String url, String requestMethod, String example, Class requestClass, Class responseClass){
       this.url = url;
       this.requestMethod = requestMethod;
       this.example = example;
       this.requestClass = requestClass;
       this.responseClass = responseClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Class getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(Class requestClass) {
        this.requestClass = requestClass;
    }

    public Class getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class responseClass) {
        this.responseClass = responseClass;
    }
}