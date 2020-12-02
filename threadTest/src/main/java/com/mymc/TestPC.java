package com.mymc;

import java.text.SimpleDateFormat;
import java.util.Date;

//思路：管程法
//测试生产者和消费者问题
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}


//生产者
class Productor extends Thread{
    //需要向容器中加入产品
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            //生产者添加产品
            container.push(new Chicken(i));
            System.out.println("生产者生产了"+i+"鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            //消费者拿走产品
            Chicken chicken = container.pop();
            System.out.println("消费者消费了"+chicken.id+"鸡");
        }
    }
}


//缓冲区-->容器
class SynContainer{

    //容器
    Chicken[] chickens = new Chicken[10];
    Date startTime ;






    //容器的计数器
    int num = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {

        //假如容易已经满了,就不用放,等待消费者消费
        if (num>=chickens.length){

            //等待消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //假如容器没有满 , 通知生产生成

        System.out.println("num,,,,,"+num+"____"+System.currentTimeMillis());
        chickens[num] = chicken;
        System.out.println("数组有多少个元素"+num+"____"+System.currentTimeMillis());
        num++;
        //通知消费者消费
        this.notifyAll();

    }

    //消费者拿走产品
    public synchronized Chicken pop(){
        startTime = new Date(System.currentTimeMillis());
        //假如容器空的,等待
        if (num<=0){
            //等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        num--;
        Chicken chicken = chickens[num];

        //通知生产者生产
        this.notifyAll();
        return chicken;
    }


}

//产品->鸡
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}


