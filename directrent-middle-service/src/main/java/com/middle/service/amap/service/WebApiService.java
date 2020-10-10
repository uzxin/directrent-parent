package com.middle.service.amap.service;

import com.middle.service.amap.enums.WebApiUrlEnum;
import com.middle.service.amap.vo.AmapConstant;
import com.middle.service.amap.vo.req.*;
import com.middle.service.amap.vo.resp.*;
import com.middle.service.common.util.HttpClient;
import com.middle.service.common.util.JsonUtil;
import com.middle.service.common.util.ObjectUtil;
import com.middle.service.common.vo.HttpClientResult;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: 高德地图web服务
 * @author: YX
 * @date: 2020/9/22 16:28
 */
@Service
public class WebApiService {

    /**
     * IP定位
     *
     * @param: req
     * @return: com.middle.service.amap.vo.resp.IPconfigResp
     * @author: YX
     * @date: 2020/9/22 17:48
     */
    public static IPconfigResp IPConfig(IPconfigReq req) throws Exception {
        Map<String, String> params = ObjectUtil.objectToStrMap(req);
        params.put("key", AmapConstant.KEY);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.IP_CONFIG.getUrl(), params);
        IPconfigResp iPconfigResp = JsonUtil.jsonStrToBean(result.getContent(), IPconfigResp.class);
        return iPconfigResp;
    }

    /**
     * 获取天气信息
     *
     * @param: req
     * @return: com.middle.service.amap.vo.resp.WeatherInfoResp
     * @author: YX
     * @date: 2020/9/23 11:31
     */
    public static WeatherInfoResp weatherInfo(WeatherInfoReq req) throws Exception {
        Map<String, String> params = ObjectUtil.objectToStrMap(req);
        params.put("key", AmapConstant.KEY);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.WEATHER_INFO.getUrl(), params);
        WeatherInfoResp weatherInfoResp = JsonUtil.jsonStrToBean(result.getContent(), WeatherInfoResp.class);
        return weatherInfoResp;
    }

    /**
     * 地理编码
     * 结构化地址转经纬度
     *
     * @param: req
     * @return: com.middle.service.amap.vo.resp.GeoResp
     * @author: YX
     * @date: 2020/10/10 15:27
     */
    public static GeoResp geo(GeoReq req) throws Exception {
        Map<String, String> params = ObjectUtil.objectToStrMap(req);
        params.put("key", AmapConstant.KEY);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.GEO.getUrl(), params);
        GeoResp geoResp = JsonUtil.jsonStrToBean(result.getContent(), GeoResp.class);
        return geoResp;
    }

    /**
     * 逆地理编码
     * 经纬度转结构化地址
     *
     * @param: req
     * @return: com.middle.service.amap.vo.resp.RegeoResp
     * @author: YX
     * @date: 2020/10/10 16:16
     */
    public RegeoResp regeo(RegeoReq req) throws Exception {
        Map<String, String> params = ObjectUtil.objectToStrMap(req);
        params.put("key", AmapConstant.KEY);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.REGEO.getUrl(), params);
        RegeoResp regeoResp = JsonUtil.jsonStrToBean(result.getContent(), RegeoResp.class);
        return regeoResp;
    }

    /**
     * 路径规划(步行)
     *
     * @param: req
     * @return: com.middle.service.amap.vo.resp.WalkingDirectionResp
     * @author: YX
     * @date: 2020/10/10 17:19
     */
    public WalkingDirectionResp direction_walking(WalkingDirectionReq req) throws Exception {
        Map<String, String> params = ObjectUtil.objectToStrMap(req);
        params.put("key", AmapConstant.KEY);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.DIRECTION_WALKING.getUrl(), params);
        WalkingDirectionResp walkingDirectionResp = JsonUtil.jsonStrToBean(result.getContent(), WalkingDirectionResp.class);
        return walkingDirectionResp;
    }



    public static void main(String[] args) throws Exception {
        /*IPconfigReq iPconfigReq = new IPconfigReq();
        iPconfigReq.setIp("114.55.28.2");
        IPconfigResp iPconfigResp = IPConfig(iPconfigReq);
        System.out.println(iPconfigResp);*/
        /*WeatherInfoReq weatherInfoReq = new WeatherInfoReq();
        weatherInfoReq.setCity("510100");
        weatherInfoReq.setExtensions("all");
        WeatherInfoResp weatherInfoResp = weatherInfo(weatherInfoReq);
        System.out.println(weatherInfoResp);*/
        /*GeoReq geoReq = new GeoReq();
        geoReq.setAddress("四川省成都市双流区西航港街道133号");
        GeoResp geoResp = geo(geoReq);
        System.out.println(geoResp);*/
        /*RegeoReq regeoReq = new RegeoReq();
        regeoReq.setLocation("116.481488,39.990464");
        regeoReq.setPoitype("商务写字楼");
        regeoReq.setRadius(1000);
        regeoReq.setExtensions("all");
        regeoReq.setRoadlevel(0);
        RegeoResp regeoResp = regeo(regeoReq);
        System.out.println(regeoResp);*/
    }
}