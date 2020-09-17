package com.directrent.house.service;

import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.vo.req.HouseBaseInfoReq;

import java.util.List;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/03 21:52
 */
public interface HouseBaseInfoService {

    /**
     * 获取房源列表
     *
     * @param: houseBaseInfoReq
     * @return: java.util.List<com.directrent.house.domain.HouseBaseInfo>
     * @author: YX
     * @date: 2020/09/16 21:14
     */
    List<HouseBaseInfo> page(HouseBaseInfoReq houseBaseInfoReq);

    /**
     * 获取总数
     *
     * @return: int
     * @author: YX
     * @date: 2020/09/16 21:45
     */
    int count();
}
