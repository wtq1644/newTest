package com.mymc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Period;


public class Test3 {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class c1=person.getClass();
        //类的名字
        System.out.println(c1.getName());//包名+类名
        System.out.println(c1.getSimpleName());//类名
        //获得属性

        Field[] field1=c1.getFields();//只能找到public属性
        for (Field f :field1) {
            System.out.println(f);
        }
        Field[] field2=c1.getDeclaredFields();//获得所有属性
        for (Field f :field2) {
            System.out.println(f);
        }
        System.out.println("-----------------------------------------");
        //获得指定的属性
        Field tid=c1.getDeclaredField("name");
        System.out.println(tid);

        System.out.println("-----------------------------------------");
        //获得类的方法
        System.out.println("--------------------");
        Method[] methods=c1.getMethods();//只能获取public方法(本类和父类)
        for (Method method:methods) {
            System.out.println("1"+method);
        }
        methods=c1.getDeclaredMethods();//可以获得所有方法（只有本类）
        for (Method method:methods) {
            System.out.println("2"+method);
        }

        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);
        //获得指定方法只需要在（）中添加参数（方法名，方法参数类）
        //获得指定构造器
        System.out.println("-------------------------");
        Constructor[] constructors=c1.getConstructors();//获得public构造器
        for (Constructor c :constructors) {
            System.out.println("#"+c);
        }
        constructors=c1.getDeclaredConstructors();//获得所有构造器
        for (Constructor c :constructors) {
            System.out.println("$"+c);
        }
        //获得指定构造器
        c1.getDeclaredConstructor(String.class);

    }
}
