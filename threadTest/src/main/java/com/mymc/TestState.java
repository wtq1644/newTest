package com.mymc;

//观测线程的状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{           //这里的lamda指向的是runnable接口
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("111111");
        });

        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state);

        //启动线程后
        thread.start();
        state=thread.getState();
        System.out.println(state);

        while(state!=Thread.State.TERMINATED){
            Thread.sleep(1000);
            state=thread.getState();//更新线程状态
            System.out.println(state);
        }


    }
}

