package com.directrent.common.utils;

import java.util.UUID;

/**
 * @description: UUID工具类
 * @author: YX
 * @date: 2020/09/10 21:31
 */
public class UUIDUtil {

    /**
     * 获取一个
     *
     * @return: java.lang.String
     * @author: YX
     * @date: 2020/9/10 0010 21:33
     */
    public static String get(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * 获取一堆
     *
     * @param: number
     * @return: java.lang.String[]
     * @author: YX
     * @date: 2020/9/10 0010 21:33
     */
    public static String[] get(int number){
        if(number < 1){
            return null;
        }
        String[] retArray = new String[number];
        for(int i=0;i<number;i++){
            retArray[i] = get();
        }
        return retArray;
    }
}