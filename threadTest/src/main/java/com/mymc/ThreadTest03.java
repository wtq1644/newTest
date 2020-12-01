package com.mymc;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


//实现网图下载
public class ThreadTest03 extends Thread {
    private String url;//图片的地址
    private String name;//保存的文件名

    public ThreadTest03(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDonwloader webDonwloade = new WebDonwloader();
        webDonwloade.downloader(url,name);
        System.out.println("将图片保存的的文件名是："+name);
    }

    public static void main(String[] args) {
        String url = "https://img-blog.csdnimg.cn/20200222093646898.png?type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTQ2ODM5MA==,size_16,color_FFFFFF,t_70";
        ThreadTest03 threadTest03 = new ThreadTest03(url,"1.jpg");
        threadTest03.start();
    }

}

class WebDonwloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，dowloader方法出现问题");
        }

    }
}
