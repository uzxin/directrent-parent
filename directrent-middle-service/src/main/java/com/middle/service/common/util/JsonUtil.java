package com.middle.service.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @description: json工具类
 * @author: YX
 * @date: 2020/9/22 17:08
 */
public class JsonUtil {

    /**
     * json字符串转为javaBean
     *
     * @param: jsonStr json字符串
     * @param: clazz 要转换的Java对象
     * @return: T
     * @author: YX
     * @date: 2020/9/22 17:38
     */
    public static <T> T jsonStrToBean(String jsonStr, Class<T> clazz){
        return JSON.parseObject(jsonStr, clazz);
    }
}