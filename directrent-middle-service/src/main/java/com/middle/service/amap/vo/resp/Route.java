package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 路线信息
 * @author: YX
 * @date: 2020/10/10 16:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Route {

    /**
     * 起点坐标
     */
    private String origin;
    /**
     * 终点坐标
     */
    private String destination;
    /**
     * 步行方案
     */
    private List<Path> paths;
}