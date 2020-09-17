package com.directrent.house.dao.mapper;

import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.domain.HouseBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HouseBaseInfoMapper {
    long countByExample(HouseBaseInfoExample example);

    int deleteByExample(HouseBaseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseBaseInfo record);

    int insertSelective(HouseBaseInfo record);

    List<HouseBaseInfo> selectByExampleWithRowbounds(HouseBaseInfoExample example, RowBounds rowBounds);

    List<HouseBaseInfo> selectByExample(HouseBaseInfoExample example);

    HouseBaseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseBaseInfo record, @Param("example") HouseBaseInfoExample example);

    int updateByExample(@Param("record") HouseBaseInfo record, @Param("example") HouseBaseInfoExample example);

    int updateByPrimaryKeySelective(HouseBaseInfo record);

    int updateByPrimaryKey(HouseBaseInfo record);
}