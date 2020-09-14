package com.directrent.common.utils;

import java.util.Random;

/**
 * @description: 随机数生成工具类
 * @author: YX
 * @date: 2020/09/07 11:23
 */
public class RandomUtil {
    private RandomUtil(){}

    private static int[] allNum = {0,1,2,3,4,5,6,7,8,9};

    private static final Random random = new Random();

    public static String getRandomNum(int length){
        if (length <= 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<length;i++){
            stringBuilder.append(allNum[random.nextInt(10)]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        String randomNum = getRandomNum(18);
        System.out.println(randomNum);
    }
}
