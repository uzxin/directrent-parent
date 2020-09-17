package com.directrent.excelData.dao.mapper;

import com.directrent.excelData.domain.Excel;
import com.directrent.excelData.domain.ExcelExample;
import java.util.List;

import com.directrent.excelData.dto.ExcelDataDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExcelMapper {
    long countByExample(ExcelExample example);

    int deleteByExample(ExcelExample example);

    int insert(Excel record);

    int insertSelective(Excel record);

    List<Excel> selectByExampleWithRowbounds(ExcelExample example, RowBounds rowBounds);

    List<Excel> selectByExample(ExcelExample example);

    int updateByExampleSelective(@Param("record") Excel record, @Param("example") ExcelExample example);

    int updateByExample(@Param("record") Excel record, @Param("example") ExcelExample example);

    int batchInsert(List<ExcelDataDTO> excelDataDTOS);

    Excel getByFolder(@Param("folder") String folder);
}