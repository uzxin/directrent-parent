package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 每段步行方案
 * @author: YX
 * @date: 2020/10/10 17:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Step {

    /**
     * 路段步行指示
     */
    private String instruction;
    /**
     * 道路名称
     */
    private String road;
    /**
     * 此路段距离,单位：米
     */
    private String distance;
    /**
     * 方向
     */
    private String orientation;
    /**
     * 此路段预计步行时间
     */
    private String duration;
    /**
     * 此路段坐标点
     */
    private String polyline;
    /**
     * 步行主要动作
     */
    private String action;
    /**
     * 步行辅助动作
     */
    private String assistant_action;
    /**
     * 这段路是否存在特殊的方式
     * 0，普通道路   1，人行横道  3，地下通道  4，过街天桥  5，地铁通道  6，公园    7，广场    8，扶梯    9，直梯    10，索道
     * 11，空中通道  12，建筑物穿越通道  13，行人通道 14，游船路线 15，观光车路线    16，滑道   18，扩路   19，道路附属连接线
     * 20，阶梯    21，斜坡   22，桥    23，隧道   30，轮渡
     */
    private int walk_type;
}