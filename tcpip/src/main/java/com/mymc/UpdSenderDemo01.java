package com.mymc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class UpdSenderDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        //准备数据，从控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String msg = reader.readLine();
            byte[] data = msg.getBytes();
            //准备封装发送包
            DatagramPacket sendPacket = new DatagramPacket(data,
                    data.length,
                    new InetSocketAddress("localhost",6666));
            //发送
            socket.send(sendPacket);
            if(msg.equals("bye")){
                break;
            }
        }
        //关闭流
        socket.close();
    }
}

