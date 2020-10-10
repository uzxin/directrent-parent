package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 社区信息
 * @author: YX
 * @date: 2020/10/10 15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Neighborhood {

    /**
     * 社区名称
     */
    private String name;
    /**
     * POI类型
     */
    private String type;
}