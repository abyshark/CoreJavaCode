package com.demo.threading;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Demo 2 Daemon Thread...");
        Thread bgThread = new Thread(new DaemonHelper());
        Thread usrThread = new Thread(new UserThreadHelper());

        bgThread.setDaemon(true);
        bgThread.start();
        usrThread.start();
    }
}

class DaemonHelper implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon Helper Thread running ... ");
        }
    }
}

class UserThreadHelper implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User Helper Thread Done with Execution ... ");
    }
}