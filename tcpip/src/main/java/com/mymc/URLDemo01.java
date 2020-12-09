package com.mymc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws Exception {
        //1、下载资源（参数为地址）
        URL url = new URL("https://www.csgo.com.cn/images/footer/head_default.png");
        System.out.println(url.getProtocol());  //协议名
        System.out.println(url.getHost());  //IP名字
        System.out.println(url.getPort());   //端口号
        System.out.println(url.getPath());   //文件
        System.out.println(url.getFile());   //文件全路径
        System.out.println(url.getQuery());   //参数

        //2、连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream is = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("DownLoad.png");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);  //写出这个数据
        }

        //关闭资源
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}

