package com.demo.threading;

public class Demo2Sync {

    public static int counter1=0;
    public static int counter2=0;
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        System.out.println("Demo 2 with sync at block level ...");

        Thread one = new Thread(()->{
           for(int i =0;i<10000;i++){
               increment1();
           }
        });

        Thread two = new Thread(()->{
           for (int i =0;i<10000;i++){
               increment2();
           }
        });
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter1+" ---- "+counter2);
    }

    /*
    Here the lock needs to be acquired by the thread in order to
    This method/block of code
    This will not affect the execution on other lines of code
     */
    private static void increment1(){
        synchronized (lock1){
            counter1++;
        }
    }

    private static void increment2(){
        synchronized (lock2){
            counter2++;
        }
    }
}
