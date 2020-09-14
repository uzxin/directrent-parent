package com.directrent.excelData.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/10 22:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelDataDTO {

    private Long houseId;

    @ExcelProperty(value = "详情", index = 1)
    private String details;
    @ExcelProperty(value = "详情", index = 2)
    private String name;
    @ExcelProperty(value = "详情", index = 3)
    private String folder;
    @ExcelProperty(value = "详情", index = 4)
    private String lable;
    @ExcelProperty(value = "详情", index = 5)
    private String area;
    @ExcelProperty(value = "详情", index = 6)
    private String towards;
    @ExcelProperty(value = "详情", index = 7)
    private String unitType;
    @ExcelProperty(value = "详情", index = 8)
    private String position;
    @ExcelProperty(value = "详情", index = 9)
    private String floor;
    @ExcelProperty(value = "详情", index = 10)
    private String elevator;
    @ExcelProperty(value = "详情", index = 11)
    private String buildYear;
    @ExcelProperty(value = "详情", index = 12)
    private String doorLockType;
    @ExcelProperty(value = "详情", index = 13)
    private String greeningRate;
    @ExcelProperty(value = "详情", index = 14)
    private String description;
    @ExcelProperty(value = "详情", index = 15)
    private String config;
    @ExcelProperty(value = "详情", index = 16)
    private String roommate;
    @ExcelProperty(value = "详情", index = 17)
    private String price;
}