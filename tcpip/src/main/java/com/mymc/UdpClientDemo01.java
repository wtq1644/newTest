package com.mymc;

import java.io.IOException;
import java.net.*;

//不需要链接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws IOException {
        //1、建立一个socket
        DatagramSocket socket = new DatagramSocket();
        //2、建立一个包
        String msg = "你好啊!服务器";

        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port  = 9090;

        //参数分别为：发送的消息，数据的起始长度，发送的地址，端口号
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //发送包
        socket.send(packet);

        //关闭流
        socket.close();
    }
}

