package com.hly.java.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :hly
 * @date :2018/6/9
 */
//Annotation用于声明
/**
 * Target设置Annotation适用的程序类型,如下分别是
 * Annotation类型
 * 类，接口，每局，Annotation
 * 构造方法
 * 成员变量，每局常量
 * 方法
 * 参数
 * 局部变量
 * 包
 */
/**
 * Retention设置Annotation的有效范围
 * RUNTIME 运行加载JVM，范围最大
 * SOURCE 不编译到类文件中，范围最小
 * CLASS编译到类文件中，不加载到JVM中
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.LOCAL_VARIABLE,ElementType.PACKAGE})
public @interface PersonAnnotation {
    //String value();如果只包含一个变量
    String name() default "hly";
    Class type() default void.class;



}
