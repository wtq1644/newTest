package com.mymc;

import java.util.Scanner;

public class Demo04_Scanner {
    public static void main(String[] args) {
        //我们可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果:
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        //通过循环判断是否还有输入，并在里面对每-次进行求和和统计
        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m=m+1; //m++
            sum=sum+x;
            System.out.println("你输入了第"+m+"个数据，然后当前结果sum=" +sum) ;
        }
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m +"个数的平均值是" + (sum / m));
        scanner.close();
    }
}

