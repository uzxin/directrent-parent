package com.directrent.house.dao.mapper;

import com.directrent.house.domain.HouseImage;
import com.directrent.house.domain.HouseImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HouseImageMapper {
    long countByExample(HouseImageExample example);

    int deleteByExample(HouseImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseImage record);

    int insertSelective(HouseImage record);

    List<HouseImage> selectByExampleWithRowbounds(HouseImageExample example, RowBounds rowBounds);

    List<HouseImage> selectByExample(HouseImageExample example);

    HouseImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseImage record, @Param("example") HouseImageExample example);

    int updateByExample(@Param("record") HouseImage record, @Param("example") HouseImageExample example);

    int updateByPrimaryKeySelective(HouseImage record);

    int updateByPrimaryKey(HouseImage record);
}