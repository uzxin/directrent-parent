package com.directrent.common.utils.excel;

import java.lang.annotation.*;

/**
 * @description: sheet名称
 * @author: YX
 * @date: 2020/9/1 22:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
@Inherited
public @interface SheetName {
    String value() default "";
}
