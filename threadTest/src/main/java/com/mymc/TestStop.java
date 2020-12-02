package com.mymc;

public class TestStop implements Runnable {
    private boolean flag=true;

    public static void main(String[] args) {

        TestStop t1=new TestStop();
        new Thread(t1).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main"+i);
            if(i==90) {
                t1.stop();
            }
        }
    }

    public void stop(){
        this.flag=false;
    }

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("Thread"+i++);
        }
    }
}


