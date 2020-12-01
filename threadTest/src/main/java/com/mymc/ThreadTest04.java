package com.mymc;

public class ThreadTest04 implements Runnable {
    private int ticketNum = 10;
    @Override
    public void run() {


        while(true){
            if (ticketNum<=0) {
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"拿到了第"+(ticketNum--)+"票");
        }

    }

    public static void main(String[] args) {
        ThreadTest04 threadTest04 = new ThreadTest04();
        //一个对象多个线程使用
        new Thread(threadTest04,"小明").start();
        new Thread(threadTest04,"小zhao").start();
        new Thread(threadTest04,"wxy").start();
    }


}
