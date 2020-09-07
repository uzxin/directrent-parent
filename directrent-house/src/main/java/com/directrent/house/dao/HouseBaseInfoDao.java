package com.directrent.house.dao;

import com.directrent.house.dao.extmapper.ExtHouseBaseInfoMapper;
import com.directrent.house.dao.mapper.HouseBaseInfoMapper;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.domain.HouseBaseInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/03 20:09
 */
@Repository
public class HouseBaseInfoDao {

    @Autowired
    private ExtHouseBaseInfoMapper extHouseBaseInfoMapper;
    @Autowired
    private HouseBaseInfoMapper houseBaseInfoMapper;

    public int batchInsert(List<HouseBaseInfo> houseBaseInfos){
        return extHouseBaseInfoMapper.batchInsert(houseBaseInfos);
    }

    public List<HouseBaseInfo> getAll() {
        HouseBaseInfoExample houseBaseInfoExample = new HouseBaseInfoExample();
        return houseBaseInfoMapper.selectByExample(houseBaseInfoExample);
    }

    public HouseBaseInfo selectById(Long id) {
        return houseBaseInfoMapper.selectByPrimaryKey(id);
    }
}