package com.mymc;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        new Thread(helloWorld,"A").start();
        new Thread(helloWorld,"B").start();

    }
}


class HelloWorld implements Runnable{

    int ticketNums = 20;
    //可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                lock.lock(); //加锁
                //判断是否有票
                if (ticketNums>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----"+ticketNums--);
                }else {
                    break;
                }
            } finally {
                lock.unlock();//解锁
            }

        }

    }

}

