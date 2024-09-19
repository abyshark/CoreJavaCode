package com.demo.threading;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Demo 1 for Multi Threading!!!");
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());
        Thread t4 = new ThreadFour();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println("Thread Three: " + i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ThreadOne implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Thread one: " + i);
        }
    }
}

class ThreadTwo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Thread two: " + i);
        }
    }
}

class ThreadFour extends Thread {
    @Override
    public void run() {
        System.out.println("This is Thread 4...");
    }
}

