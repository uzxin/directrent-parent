package com.directrent.house.dao;

import com.directrent.house.dao.extmapper.ExtHouseBaseInfoMapper;
import com.directrent.house.dao.mapper.HouseBaseInfoMapper;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.domain.HouseBaseInfoExample;
import com.directrent.house.vo.req.HouseBaseInfoReq;
import org.apache.ibatis.session.RowBounds;
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

    /**
     * 批量插入
     *
     * @param: houseBaseInfos
     * @return: int
     * @author: YX
     * @date: 2020/09/16 21:18
     */
    public int batchInsert(List<HouseBaseInfo> houseBaseInfos){
        return extHouseBaseInfoMapper.batchInsert(houseBaseInfos);
    }

    /**
     * 查询所有
     *
     * @return: java.util.List<com.directrent.house.domain.HouseBaseInfo>
     * @author: YX
     * @date: 2020/09/16 21:19
     */
    public List<HouseBaseInfo> getAll() {
        HouseBaseInfoExample houseBaseInfoExample = new HouseBaseInfoExample();
        return houseBaseInfoMapper.selectByExample(houseBaseInfoExample);
    }

    /**
     * 条件查询+分页查询
     *
     * @param: houseBaseInfoReq
     * @return: java.util.List<com.directrent.house.domain.HouseBaseInfo>
     * @author: YX
     * @date: 2020/09/16 21:19
     */
    public List<HouseBaseInfo> getBycondition(HouseBaseInfoReq houseBaseInfoReq) {
        //构建分页对象
        RowBounds rowBounds = new RowBounds(houseBaseInfoReq.getPage()-1, houseBaseInfoReq.getLimit());
        return houseBaseInfoMapper.selectByExampleWithRowbounds(null, rowBounds);
    }

    /**
     * 获取记录数
     *
     * @return: int
     * @author: YX
     * @date: 2020/09/16 21:46
     */
    public int count() {
        return extHouseBaseInfoMapper.count();
    }
}