package com.middle.service.common.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: object工具
 * @author: YX
 * @date: 2020/9/22 16:31
 */
public class ObjectUtil {

    private static final Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    /**
     * object转map
     *
     * @param: t
     * @return: java.util.Map<java.lang.String, java.lang.String>
     * @author: YX
     * @date: 2020/9/22 16:53
     */
    public static <T> Map<String, String> objectToStrMap(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        Map<String, String> result = new HashMap<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.get(t) != null){
                    result.put(field.getName(), JSON.toJSONString(field.get(t)));
                }
                field.setAccessible(false);
            }catch (Exception e){
                logger.error(e.getLocalizedMessage(), e);
            }
        }
        return result;
    }
}
