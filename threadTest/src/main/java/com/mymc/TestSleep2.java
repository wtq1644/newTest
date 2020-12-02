package com.mymc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
        //获取系统时间
        Date startTime = new Date(System.currentTimeMillis());

//        tenDown();
        while (true) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            Thread.sleep(1000);
            startTime = new Date(System.currentTimeMillis());//更新当前时间
        }

    }

    //倒计时方法
    private static void tenDown() throws InterruptedException {
        for (int i = 10; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println("倒计时:"+i);
        }

    }


}

