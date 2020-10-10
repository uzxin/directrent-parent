package com.middle.service.amap.vo.resp;

import lombok.*;

/**
 * @description: 路径规划（步行）返回对象
 * @author: YX
 * @date: 2020/10/10 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WalkingDirectionResp extends BaseResp {

    /**
     * 路线信息列表
     */
    private Route route;
}