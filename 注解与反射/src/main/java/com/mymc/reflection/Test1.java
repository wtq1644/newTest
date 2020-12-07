package com.mymc.reflection;

public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1=Class.forName("com.mymc.reflection.User");
        Class c2=Class.forName("com.mymc.reflection.User");
        //打印hashcode可以看出一个类在内存中只有一个Class对象
        //一个类被被载后，类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
