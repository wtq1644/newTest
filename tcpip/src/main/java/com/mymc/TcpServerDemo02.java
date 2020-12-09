package com.mymc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2、监听客户端链接
        Socket socket = serverSocket.accept();//阻塞式监听，会一直等待客户端连接
        //3、获取输入流
        InputStream is = socket.getInputStream();
        //4、文件输出
        FileOutputStream fos = new FileOutputStream("received.jpeg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        //通知客户端我已经接收完毕了
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("来自Server的消息：我已经接收完毕！".getBytes());

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}


