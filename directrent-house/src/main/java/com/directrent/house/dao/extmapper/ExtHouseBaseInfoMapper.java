package com.directrent.house.dao.extmapper;

import com.directrent.house.domain.HouseBaseInfo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过id查询
     *
     * @param: id
     * @return: com.directrent.house.domain.HouseBaseInfo
     * @author: YX
     * @date: 2020/9/10 0010 23:53
     */
    HouseBaseInfo getById(@Param("id") Long id);
}
