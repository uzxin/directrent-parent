package com.directrent.common.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/07 11:23
 */
public class ObjectUtil {
    private static final Logger logger = LoggerFactory.getLogger(ObjectUtil.class);
    private ObjectUtil(){}

    // 因为始用了统一数据字典缓存，所以该方法暂时不始用了注释掉
//    public static<T> void dictToObject(List<Dict> dicts, T t, Map<String, String> config){
//        Class<?> clazz = t.getClass();
//        dicts.forEach(dict -> {
//            String name = dict.getName();
//            if (config != null && config.get(name) != null){
//                name = config.get(name);
//            }
//            try {
//                Field field = clazz.getDeclaredField(name);
//                field.setAccessible(true);
//                Type type = field.getGenericType();
//                if ("int".equals(type.getTypeName()) || "java.lang.Integer".equals(type.getTypeName())){
//                    field.set(t, Integer.valueOf(dict.getValue()));
//                }else if ("double".equals(type.getTypeName()) || "java.lang.Double".equals(type.getTypeName())){
//                    field.set(t, Double.valueOf(dict.getValue()));
//                }else if ("long".equals(type.getTypeName()) || "java.lang.Long".equals(type.getTypeName())){
//                    field.set(t, Long.valueOf(dict.getValue()));
//                }else if ("java.math.BigDecimal".equals(type.getTypeName())){
//                    field.set(t, new BigDecimal(dict.getValue()));
//                }else if ("boolean".equals(type.getTypeName()) || "java.lang.Boolean".equals(type.getTypeName())){
//                    field.set(t, Boolean.valueOf(dict.getValue()));
//                }else if ("java.lang.String[]".equals(type.getTypeName())){
//                    field.set(t, StringUtils.split(dict.getValue(), ","));
//                }
//                else {
//                    field.set(t, dict.getValue());
//                }
//                field.setAccessible(false);
//            } catch (Exception e) {
//                logger.error("name:{},failed", name);
//            }
//        });
//    }

//    public static void main(String[] args){
//        Dict dict = new Dict();
//        dict.setName("xxx");
//        dict.setSort(1L);
//        dict.setCreateDate(new Date());
//        Map<String, String> result = objectToStrMap(dict);
//        System.out.println(result);
//    }

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
