package com.middle.service.amap.service;

import com.middle.service.amap.enums.WebApiUrlEnum;
import com.middle.service.amap.vo.AmapConstant;
import com.middle.service.amap.vo.req.IPconfigReq;
import com.middle.service.amap.vo.resp.IPconfigResp;
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
        params.put("key",AmapConstant.key);
        HttpClientResult result = HttpClient.doGet(WebApiUrlEnum.ipconfig.getUrl(), params);
        IPconfigResp iPconfigResp = JsonUtil.jsonStrToBean(result.getContent(), IPconfigResp.class);
        return iPconfigResp;
    }

    public static void main(String[] args) throws Exception {
        IPconfigReq iPconfigReq = new IPconfigReq();
        iPconfigReq.setIp("114.55.28.2");
        IPconfigResp iPconfigResp = IPConfig(iPconfigReq);
        System.out.println(iPconfigResp);
    }
}