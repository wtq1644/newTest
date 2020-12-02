package com.mymc;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("线程创建成功");
        return true;
    }

    public static void main(String[] args) {
        TestCallable callable = new TestCallable();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> res = service.submit(callable);

        boolean isTrue = false;
        try {
            isTrue = res.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(isTrue);

        service.shutdownNow();//关闭

    }

}

