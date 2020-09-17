package com.directrent.house.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 房源基本信息
 * @author: YX
 * @date: 2020/09/02 20:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseBaseInfoDTO {

    /**
     * index值为对应excel中的列，value为表头，format为日期格式化
     */
    @ExcelProperty(value = "名字", index = 2)
    private String name;

    @ExcelProperty(value = "面积", index = 5)
    private String area;

    @ExcelProperty(value = "朝向", index = 6)
    private String towards;

    @ExcelProperty(value = "户型", index = 7)
    private String unitType;

    @ExcelProperty(value = "位置", index = 8)
    private String position;

    @ExcelProperty(value = "楼层", index = 9)
    private String floor;

    @ExcelProperty(value = "有无电梯", index = 10)
    private String elevator;

    @ExcelProperty(value = "建造年份", index = 11)
    private String buildYear;

    @ExcelProperty(value = "门锁类型", index = 12)
    private String doorLockType;

    @ExcelProperty(value = "绿化率", index = 13)
    private String greeningRate;

    @ExcelProperty(value = "描述", index = 14)
    private String description;

    @ExcelProperty(value = "价格", index = 17)
    private String price;

}