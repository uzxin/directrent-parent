package com.directrent.common.utils;

import java.util.Random;

/**
 * @PackageName: com.just.butterfly.biz.common.util
 * @Description:
 * @author: traveller
 * @date: 2018/8/30 10:55
 * @Copyright: 2018 www. .com Inc. All rights reserved.
 * 注意：本内容仅限于西藏佳斯特信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
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
        String randomNum = getRandomNum(4);
        System.out.println(randomNum);
    }
}
