package com.andy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数注解
 * Created by andy on 2016/12/21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)

public @interface ParamterDescription{
    String name() default ""; //参数名称
    String description() default ""; //参数描述

}
