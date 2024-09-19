package com.demo.threading;

public class Demo3Priority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName());

        Thread one = new Thread(() -> {
            System.out.println("Thread One say hi ...");
        });

        Thread two = new Thread(() -> {
            System.out.println("Thread Two says hi...");
        });
        System.out.println(Thread.currentThread().getName());
        //Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        // one.setPriority(Thread.MAX_PRIORITY);
        two.setPriority(Thread.MAX_PRIORITY);
        one.start();
        two.start();
        System.out.println(Thread.currentThread().getName() + " Says hi ...");


    }
}
