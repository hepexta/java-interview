package com.hepexta.interview.concurrency;

public class ObjectMonitor {
    public static void main(String[] args) {
        new ObjectMonitor().doCounter();
    }

    private volatile int count = 0;
    private final Object monitor = new Object();

    private synchronized void incrementSync() {
        count++;
    }

    private void increment() {
        synchronized (monitor) {
            // Critical section - section for one thread only (inside synchronized block )
            count++;
        }
    }

    private void doCounter() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1_000;i++){
                    increment();
                    System.out.println(count);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1_000;i++){
                    increment();
                    System.out.println(count);
                }
            }
        });

        t1.start();
        t2.start();
    }

}
