package com.mymc;

public class Test1 {

    String yuju;
    int a =7 ;

    {
        System.out.println("666");
    }

    public String getYuju() {
        return yuju;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setYuju(String yuju) {
        this.yuju = yuju;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test1 test2=new Test1();
        test1.setYuju("676767");
        test1.setA(give.b);
        System.out.println(test1.getA());
        System.out.println(test1.yuju);
    }
}

class give{

    static int b = 3;
}
