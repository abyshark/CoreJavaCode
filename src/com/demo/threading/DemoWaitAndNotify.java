package com.demo.threading;

public class DemoWaitAndNotify {

    public static final Object LOCK = new Object();
    public static void main(String[] args) {
        System.out.println("Demo for wait and notify in Threads...");

        Thread t1 = new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(DemoWaitAndNotify::two);

        t1.start();
        t2.start();
    }


    public static void one() throws InterruptedException {
        synchronized (LOCK){
            System.out.println("Hello from method one...");
            LOCK.wait();
            System.out.println("Back again in method one...");
        }
    }
    public static void two(){
        synchronized(LOCK){
            System.out.println("Hello from Method two...");
            LOCK.notify();
            System.out.println("Back in Method two after notify...");
        }
    }
}
