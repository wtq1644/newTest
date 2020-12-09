package com.mymc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        //进行循环监听
        while (true){
            try {
                //1. 我得有一个地址
                serverSocket = new ServerSocket(9999);
                //2. 等待客户端链接过来
                socket = serverSocket.accept();
                //3. 读取客户端的消息
                inputStream = socket.getInputStream();
                //4. 管道流,首先先接收传过来的Stream
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while(( len=inputStream.read(buffer)) != -1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                //先开后关原则
                if(baos != null){
                    baos.close();
                }
                if (inputStream != null){
                    inputStream.close();
                }
                if (socket != null){
                    socket.close();
                }
                if (serverSocket != null){
                    serverSocket.close();
                }
            }
        }
    }



}
