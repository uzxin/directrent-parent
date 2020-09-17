package com.directrent.house.vo.req;

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
public class HouseBaseInfoReq implements Serializable {

    /**
     * 当前页
     */
    private int page;
    /**
     * 分页大小
     */
    private int limit;
}