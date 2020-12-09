package com.mymc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo01 {


    public static void main(String[] args) throws IOException {
        //1. 要知道服务器的地址
        InetAddress ServerId = InetAddress.getByName("127.0.0.1");
        //2. 端口号
        int port  = 9999;
        //3. 创建一个socket链接
        Socket socket = new Socket(ServerId,port);
        //4. 发送消息 IO流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好欢迎光临".getBytes());
        //先开后关原则
        outputStream.close();
        socket.close();
    }

}
