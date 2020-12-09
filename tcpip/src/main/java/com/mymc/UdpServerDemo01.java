package com.mymc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//要等待客户端的链接
public class UdpServerDemo01 {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接收
        socket.receive(packet);//阻塞接收

        //控制台输出数据包
        System.out.println(packet.getAddress().getHostAddress());
        //String里面的参数为byte数组，起始位置，末尾位置（长度）
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //关闭连接
        socket.close();
    }
}
