package com.mymc;


import java.io.IOException;

public class TalkStudent {
    public static void main(String[] args) throws IOException {
        //开启两个线程
        new Thread(new TalkSend(7777,"localhost",4567)).start();
        new Thread(new TalkReceive(8888,"老师")).start();
    }
}

