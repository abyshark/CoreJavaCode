package com.demo.threading;

import java.util.concurrent.*;

public class DemoThreadPool {
    public static void main(String[] args) {
        System.out.println("Demo for thread pool executor service !!!");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,3,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        int count =10;
        //while (count>0){
            for(int i =0;i<count;i++){
                //count--;
            executor.submit(()->{
                try {
                    Thread.sleep(1000);
                    DemoThreadPool.printMsg();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            //}
        }
        executor.shutdown();
    }

    public static void printMsg(){
        System.out.println("Thread has entered the system: "+ Thread.currentThread().getName());
    }
}
