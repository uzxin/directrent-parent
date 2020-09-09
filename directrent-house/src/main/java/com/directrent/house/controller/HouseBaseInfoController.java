package com.directrent.house.controller;

import com.directrent.common.vo.LayuiResult;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.service.HouseBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 房源基本信息
 * @author: YX
 * @date: 2020/09/03 21:50
 */
@RestController
@RequestMapping("web/v1.0/house/baseinfo")
public class HouseBaseInfoController {

    @Autowired
    private HouseBaseInfoService houseBaseInfoService;

    @GetMapping("list")
    public LayuiResult list(int page, int limit){
        List<HouseBaseInfo> houseBaseInfos = houseBaseInfoService.list();
        return new LayuiResult(0,"", houseBaseInfos.size(), houseBaseInfos);
    }

    @GetMapping("test")
    public LayuiResult test(){
        return LayuiResult.ok("uzxin111");
    }
}