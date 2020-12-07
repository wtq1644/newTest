package com.mymc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test2 {
    //注解可以显示复制，如果没有默认值，就必须给注解复制
    @MyAnnotation1(schools = {"BUPT","666"},age = 2,id = 6)
    public void test(){
    }
    //如果注解只有一个参数可以省略参数名
    @MyAnnotation2("")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1{
    //注解的参数：类型+参数名()[default 默认值];
    String name() default "";
    int age() default 0;
    int id() default -1;//默认值为-1，表示不存在
    String[] schools();
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：类型+参数名()[default 默认值];
    String[] value();
}

