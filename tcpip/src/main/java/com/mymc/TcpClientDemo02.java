package com.mymc;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建一个socket链接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3、读取文件流
        FileInputStream fs = new FileInputStream(new File("src/biteCat.jpeg"));
        //4、写出文件流
        byte[] buffer = new byte[1024];
        int len;
        while((len = fs.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        //通知服务器已经结束了
        socket.shutdownOutput();//我已经传输完了

        //接收服务端传来的消息
        InputStream inputStream = socket.getInputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len2 = inputStream.read(buffer2)) != -1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        //5、关闭资源
        baos.close();
        fs.close();
        os.close();
        socket.close();
    }
}

