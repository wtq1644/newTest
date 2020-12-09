package com.mymc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UpcReceiverDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while(true){
            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(container,0,container.length);
            socket.receive(receivedPacket); //阻塞式接收包裹
            //断开连接 byt
            byte[] data = receivedPacket.getData();
            //此处的Length选用receivedPacket的Length，若选用data的Length，可能会变成1024，并没有进行动态生成长度
            String receiveMsg = new String(data,0,receivedPacket.getLength());
            System.out.println(receiveMsg);
            if(receiveMsg.equals("bye")){
                break;
            }
        }
        //关闭流
        socket.close();
    }
}

