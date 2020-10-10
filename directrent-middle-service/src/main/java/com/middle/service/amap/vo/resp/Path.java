package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 步行方案
 * @author: YX
 * @date: 2020/10/10 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Path {

    /**
     * 起点和终点的步行距离,单位：米
     */
    private String distance;
    /**
     * 步行时间预计,单位：秒
     */
    private String duration;
    /**
     * 步行结果列表
     */
    private List<Step> steps;
}