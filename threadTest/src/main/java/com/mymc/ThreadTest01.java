package com.mymc;

public class ThreadTest01 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了");
    }

    public static void main(String[] args) {
        ThreadTest01 test01 = new ThreadTest01();
        test01.start();
    }
}
