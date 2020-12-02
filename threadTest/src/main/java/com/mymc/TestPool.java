package com.mymc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {



    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        MyThread myThread =new MyThread();
        service.execute(myThread);
        service.execute(myThread);
        service.execute(myThread);
        service.execute(myThread);

        service.shutdown();
    }
}

class  MyThread implements Runnable{

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10 ; i++) {
                if (i == 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i+Thread.currentThread().getName());
            }
        }
//        System.out.println(Thread.currentThread().getName());
    }
}