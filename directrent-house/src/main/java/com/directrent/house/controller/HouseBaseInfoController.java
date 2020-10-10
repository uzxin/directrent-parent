package com.directrent.house.controller;

import com.directrent.common.vo.LayuiResult;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.service.HouseBaseInfoService;
import com.directrent.house.vo.req.HouseBaseInfoReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "房屋基本信息接口")
public class HouseBaseInfoController {

    @Autowired
    private HouseBaseInfoService houseBaseInfoService;

    /**
     * 获取房源基本信息列表
     *
     * @param: houseBaseInfoReq
     * @return: com.directrent.common.vo.LayuiResult
     * @author: YX
     * @date: 2020/09/16 21:14
     */
    @GetMapping("page")
    @ApiOperation(value = "分页查询", notes = "page默认为1，limit默认为10")
    public LayuiResult page(@ApiParam(name = "房屋基本信息请求对象") HouseBaseInfoReq houseBaseInfoReq){
        //layui框架前端自动分页需要从后端获取总数
        int count = houseBaseInfoService.count();
        List<HouseBaseInfo> houseBaseInfos = houseBaseInfoService.page(houseBaseInfoReq);
        return LayuiResult.ok(count, houseBaseInfos);
    }

}
