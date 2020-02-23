package com.hepexta.interview.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        // demoOnSpinWait();
        demoWaitNotify();
    }

    private static void demoOnSpinWait() throws InterruptedException {
        final AtomicBoolean isGreenLight = new AtomicBoolean(false);

        Runnable waitForGreenLightAndGo = () -> {
            System.out.println("Waiting for the green light...");
            while (!isGreenLight.get()) {
                // Thread.onSpinWait(); - Java9 feature
            }
            System.out.println("Go!!!");
        };
        new Thread(waitForGreenLightAndGo).start();

        TimeUnit.MILLISECONDS.sleep(3000);

        isGreenLight.set(true);
    }

    public static void demoWaitNotify() throws InterruptedException {
        final AtomicBoolean isGreenLight = new AtomicBoolean(false);

        Object lock = new Object();

        Runnable waitForGreenLightAndGo = () -> {
            System.out.println("Waiting for the green light...");
            synchronized (lock) {
                while (!isGreenLight.get()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            System.out.println("Go!!!");
        };
        new Thread(waitForGreenLightAndGo).start();

        TimeUnit.MILLISECONDS.sleep(3000);

        synchronized (lock) {
            isGreenLight.set(true);
            lock.notify();
        }
    }


}
