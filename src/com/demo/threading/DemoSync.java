package com.demo.threading;

public class DemoSync {
    public static int count =0;
    public static void main(String[] args) {
        System.out.println("Demo for Synchronize key Word at Method Level in threads ...");

        Thread t1 = new Thread(()->{
           for(int i =0;i<10000;i++){
               increment();
           }
        });

        Thread t2 = new Thread(()->{
           for(int i =0;i<10000;i++){
               increment();
           }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count value: "+count);
    }

    /*
    this is method level synchronization
    Here we wait for one thread to execute its work then other
    Thread comes and access the value
    Whole method is blocked and cannot be accessed by other threads
    Util the first thread completes its execution
     */
    private synchronized static void increment(){
        count++;
    }
}
