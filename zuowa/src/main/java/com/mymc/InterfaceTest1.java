package com.mymc;

public interface InterfaceTest1 {
}


class ainterface implements InterfaceTest1 {
}

class test1 {
    public static void main(String[] args) {
        System.out.println(  new ainterface() instanceof InterfaceTest1);
    }
}