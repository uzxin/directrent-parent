package com.directrent.house.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 房源基本信息请求对象
 * @author: YX
 * @date: 2020/09/16 21:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class HouseBaseInfoReq implements Serializable {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页，默认为1")
    private int page;
    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小，默认为10")
    private int limit;
}