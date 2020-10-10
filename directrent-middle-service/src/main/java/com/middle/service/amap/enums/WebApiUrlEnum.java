package com.middle.service.amap.enums;

import com.middle.service.amap.vo.req.GeoReq;
import com.middle.service.amap.vo.req.IPconfigReq;
import com.middle.service.amap.vo.req.RegeoReq;
import com.middle.service.amap.vo.req.WalkingDirectionReq;
import com.middle.service.amap.vo.resp.GeoResp;
import com.middle.service.amap.vo.resp.IPconfigResp;
import com.middle.service.amap.vo.resp.RegeoResp;
import com.middle.service.amap.vo.resp.WalkingDirectionResp;

/**
 * @description: 高德地图web-api地址
 * @author: YX
 * @date: 2020/9/22 15:54
 */
public enum WebApiUrlEnum {

    /**
     * 根据ip地址获取地理位置
     */
    IP_CONFIG("https://restapi.amap.com/v3/ip", "get",
            "https://restapi.amap.com/v3/ip?ip=114.247.50.2&output=xml&key=<用户的key>", IPconfigReq.class, IPconfigResp.class),
    /**
     * 天气查询
     */
    WEATHER_INFO("https://restapi.amap.com/v3/weather/weatherInfo", "get",
            "https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=<用户key>", IPconfigReq.class, IPconfigResp.class),
    /**
     * 地理编码
     */
    GEO("https://restapi.amap.com/v3/geocode/geo","get",
            "https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=<用户的key>",GeoReq.class, GeoResp.class),
    /**
     * 逆地理编码
     */
    REGEO("https://restapi.amap.com/v3/geocode/regeo","get",
            "https://restapi.amap.com/v3/geocode/regeo?output=xml&location=116.310003,39.99157&key=<用户的key&radius=1000&extensions=all", RegeoReq.class, RegeoResp.class),
    /**
     * 路径规划（步行）
     */
    DIRECTION_WALKING("https://restapi.amap.com/v3/direction/walking","get",
            "https://restapi.amap.com/v3/direction/walking?origin=116.434307,39.90909&destination=116.434446,39.90816&key=<用户的key>", WalkingDirectionReq.class, WalkingDirectionResp.class);

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