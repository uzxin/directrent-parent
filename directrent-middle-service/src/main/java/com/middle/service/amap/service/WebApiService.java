package com.middle.service.amap.service;

import com.middle.service.amap.enums.WebApiUrlEnum;
import com.middle.service.amap.vo.AmapConstant;
import com.middle.service.amap.vo.req.IPconfigReq;
import com.middle.service.amap.vo.req.WeatherInfoReq;
import com.middle.service.amap.vo.resp.IPconfigResp;
import com.middle.service.amap.vo.resp.WeatherInfoResp;
import com.middle.service.common.util.HttpClient;
import com.middle.service.common.util.JsonUtil;
import com.middle.service.common.util.ObjectUtil;
import com.middle.service.common.vo.HttpClientResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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




    public static void main(String[] args) throws Exception {
        //HttpClientResult result = HttpClient.doGet("http://114.55.28.2:8001/web/v1.0/house/baseinfo/page?page=1&limit=10");
        //HttpClientResult result = HttpClient.doGet("https://restapi.amap.com/v3/weather/weatherInfo?city=510100&key=b4041f448e850b99ce257328c00ee71e&output=json");
        /*IPconfigReq iPconfigReq = new IPconfigReq();
        iPconfigReq.setIp("114.55.28.2");
        IPconfigResp iPconfigResp = IPConfig(iPconfigReq);
        System.out.println(iPconfigResp);*/
        WeatherInfoReq weatherInfoReq = new WeatherInfoReq();
        weatherInfoReq.setCity("510100");
        weatherInfoReq.setExtensions("all");
        WeatherInfoResp weatherInfoResp = weatherInfo(weatherInfoReq);
        System.out.println(weatherInfoResp);
    }
}