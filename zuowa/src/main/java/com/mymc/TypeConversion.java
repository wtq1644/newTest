package com.mymc;

public class TypeConversion {

    int a;

    double b;


    public static void main(String[] args) {


        int c = 10;

        double d = 0x157;

        double e;

        int f;
        String g = "123";
        Integer I2 = new Integer(c);

        Double D1=new Double(d);

        e = I2.doubleValue();
        f = D1.intValue();


        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        String s = "32.1";
        double ps = new Double(s).doubleValue();
        System.out.println(ps);
        double dd = Double.valueOf(s).doubleValue();
        System.out.println(dd);
        System.out.println(s.getClass().getName());

    }

}
