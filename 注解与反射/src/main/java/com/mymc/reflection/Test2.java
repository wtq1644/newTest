package com.mymc.reflection;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p1=new Student();
        System.out.println("这个人是"+p1.name);
        //方式1：通过对象获得
        Class c1=p1.getClass();
        //方式2：forName获得
        Class c2=Class.forName("com.mymc.reflection.Student");
        //方式3：通过类名.class获得
        Class c3=Student.class;
        //基本内置类型的包装类可以获得
        Class c4=Integer.TYPE;
        //如果输出c1/c2/c3的hashcode，可以看到是一样的
        //获得父类的类对象
        Class c5=c1.getSuperclass();
    }
}
