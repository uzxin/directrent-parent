package com.middle.service.amap.vo.resp;

import lombok.*;

import java.util.List;

/**
 * @description: 逆地理编码返回对象
 * @author: YX
 * @date: 2020/10/10 15:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RegeoResp extends BaseResp {

    /**
     * 逆地理编码列表
     */
    private List<Regeocode> regeocode;
}