package com.demo.threading;

import java.util.ArrayList;
import java.util.List;

public class DemoProducerConsumer {
    public static void main(String[] args) {
        System.out.println("Demo for Producer and Consumer Program...");
        Worker worker = new Worker(5,0);

        Thread producer = new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

    }
}

class Worker{
    public int sequence =0;
    private final int top;
    private final int bottom;
    private final List<Integer> container;
    private final Object LOCK = new Object();

    public Worker(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
        this.container = new ArrayList<>();
    }

    public void produce() throws InterruptedException {

        synchronized(LOCK){
            while (true){
                if(container.size() == top){
                    System.out.println("Container full. Waiting for items to be removed...");
                    LOCK.wait();
                }else{
                    System.out.println(sequence+" Added to the container...");
                    container.add(sequence++);
                    LOCK.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {

        synchronized (LOCK){
            while(true){
                if(container.size()==bottom){
                    System.out.println("Container is empty...");
                    LOCK.wait();
                }else {
                    sequence--;
                    System.out.println(container.remove(sequence)+" removed from the container..." );
                    LOCK.notify();
                }
                Thread.sleep(500);
            }
        }
    }


}
