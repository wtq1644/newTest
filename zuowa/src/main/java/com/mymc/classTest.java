package com.mymc;

public class classTest {
}

class Fruit{

    static String color = "五颜六色";
    static public void call() {
        System.out.println("这是一个水果");
    }
}

 class Banana extends Fruit{

    static String color = "黄色";
    static public void call() {
        System.out.println("这是一个香蕉");
    }

    public static void main(String[] args) {

        Fruit fruit = new Banana();
        System.out.println(fruit.color);    //五颜六色
        fruit.call();         //这是一个水果
    }
}