package com.andy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法注解
 * Created by andy on 2016/12/21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodDescription {
    String name() default ""; // 方法名
    String description() default ""; // 方法说明
    String author() default "无名";//作者

}
