package com.mymc;

import java.util.Scanner;

public class Demo02_Scanner {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收: ");
        //判断用户有没有输入字符串
        if (scanner.hasNext()){
            //使用next方式接收
            String str = scanner.next();//程序会等待输入内容，不输入会卡在这里
            System.out.println("输出的内容为: "+str);
        }
        //凡是属于IO流的类如果不关闭会一直占用资源.要养成好习惯用完就关掉
        scanner.close();
    }
}

/*public class Demo02_Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine方式接收: ");
        //判断是否还有输入
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println("输出的内容为: " + str);
        }
        scanner.close();
    }
}*/
