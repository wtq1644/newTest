package com.mymc;


import java.io.IOException;

public class TalkTeacher {
    public static void main(String[] args) throws IOException {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(4567,"学生")).start();
    }
}
