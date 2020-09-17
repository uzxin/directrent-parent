package com.directrent.house.service.impl;

import com.directrent.house.dao.HouseBaseInfoDao;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.service.HouseBaseInfoService;
import com.directrent.house.vo.req.HouseBaseInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/03 21:52
 */
@Service
public class HouseBaseInfoServiceImpl implements HouseBaseInfoService {

    @Autowired
    private HouseBaseInfoDao houseBaseInfoDao;

    @Override
    public List<HouseBaseInfo> page(HouseBaseInfoReq houseBaseInfoReq) {
        return houseBaseInfoDao.getBycondition(houseBaseInfoReq);
    }

    @Override
    public int count() {
        return houseBaseInfoDao.count();
    }

}