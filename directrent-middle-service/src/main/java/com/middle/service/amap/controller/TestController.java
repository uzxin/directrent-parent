package com.middle.service.amap.controller;

import com.middle.service.amap.service.WebApiService;
import com.middle.service.amap.vo.req.RegeoReq;
import com.middle.service.amap.vo.req.WalkingDirectionReq;
import com.middle.service.amap.vo.resp.RegeoResp;
import com.middle.service.amap.vo.resp.WalkingDirectionResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/10 16:31
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private WebApiService webApiService;

    @GetMapping("aa")
    public Object test1() throws Exception {
        RegeoReq regeoReq = new RegeoReq();
        regeoReq.setLocation("116.481488,39.990464");
        regeoReq.setPoitype("商务写字楼");
        regeoReq.setRadius(1000);
        regeoReq.setExtensions("all");
        regeoReq.setRoadlevel(0);
        RegeoResp regeoResp = webApiService.regeo(regeoReq);
        return regeoResp;
    }

    @GetMapping("walking")
    public Object test2() throws Exception {
        WalkingDirectionReq walkingDirectionReq = new WalkingDirectionReq();
        walkingDirectionReq.setOrigin("116.481028,39.989643");
        walkingDirectionReq.setDestination("116.434446,39.90816");
        WalkingDirectionResp walkingDirectionResp = webApiService.direction_walking(walkingDirectionReq);
        return walkingDirectionResp;
    }
}