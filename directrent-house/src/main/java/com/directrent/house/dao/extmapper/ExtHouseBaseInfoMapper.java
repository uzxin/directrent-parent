package com.directrent.house.dao.extmapper;

import com.directrent.house.domain.HouseBaseInfo;

import java.util.List;

/**
 * @description: 房源基本信息
 * @author: YX
 * @date: 2020/09/02 23:21
 */
public interface ExtHouseBaseInfoMapper {

    /**
     * 批量插入（除createTime和updateTime两个字段外）
     *
     * @param: houseBaseInfos
     * @return: int
     * @author: YX
     * @date: 2020/9/3 0003 20:07
     */
    int batchInsert(List<HouseBaseInfo> houseBaseInfos);
}
