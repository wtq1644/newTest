package com.mymc;

public class SolveLock {

    public static void main(String[] args) {
        Makeupp g1 = new Makeupp(0,"白雪公主");
        Makeupp g2 = new Makeupp(1,"灰姑凉");

        new Thread(g1).start();
        new Thread(g2).start();

    }


}

//化妆
class Makeupp implements Runnable{

    //选择
    int choice;
    //谁进来了
    String girlName;

    //两个对象
    static LipStickk lipStickk = new LipStickk();
    static Mirrork mirrork = new Mirrork();

    public Makeupp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆的方法
    public void makeup() throws InterruptedException {
        if (choice==0){ //先拿口红,再拿镜子
            synchronized (lipStickk){
                System.out.println(this.girlName+"拿到口红");
                Thread.sleep(1000);
                //等待拿镜子的人释放锁
            }
            synchronized (mirrork){
                System.out.println(this.girlName+"拿到镜子");
            }

        }else { //先拿镜子 , 再拿口红
            synchronized (mirrork){
                System.out.println(this.girlName+"拿到镜子");
                Thread.sleep(2000);
                //等待拿口红的人释放锁
            }
            synchronized (lipStickk){
                System.out.println(this.girlName+"拿到口红");
            }
        }
    }
}

//口红
class LipStickk{

}

//镜子
class Mirrork{

}
