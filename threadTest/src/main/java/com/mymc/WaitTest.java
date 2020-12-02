package com.mymc;

public class WaitTest implements Runnable{

    private int a = 11;

    @Override
    public void run(){
        synchronized(this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    try {
                        System.out.println("进入 wait 状态...");
                        wait();
                        System.out.println(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTest waitTest = new WaitTest();

        new Thread(waitTest).start();

        Thread.sleep(2000);

        synchronized (waitTest){
            System.out.println("唤醒线程...");
            waitTest.notifyAll();
        }
    }

}

