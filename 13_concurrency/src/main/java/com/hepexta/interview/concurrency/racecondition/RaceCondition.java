package com.hepexta.interview.concurrency.racecondition;

import java.util.Date;

public class RaceCondition {

    public static void main(String[] args) {
        raceConditionExample();
        raceConditionSynchronizedExample();
        raceConditionAtomicExample();
    }

    private static void raceConditionExample() {
        Counter cnt = new CounterImpl();
        runTwoThreads(cnt);
    }

    private static void raceConditionSynchronizedExample() {
        Counter cnt = new CounterSynchronized();
        runTwoThreads(cnt);
    }

    private static void raceConditionAtomicExample() {
        Counter cnt = new CounterAtomic();
        runTwoThreads(cnt);
    }

    private static void runTwoThreads(Counter cnt) {
        Thread thread1 = new Thread((getRunnable(cnt, "Thread1"+cnt.getClass().getSimpleName())));
        Thread thread2 = new Thread((getRunnable(cnt, "Thread2"+cnt.getClass().getSimpleName())));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Counter cnt, String threadName) {
        return () -> {
            long startTime = new Date().getTime();
            for (int i = 0; i < 1_000_000; i++) {
                cnt.incAndGet();
            }
            System.out.println(String.format("%s %s", threadName, cnt.get()));
            System.out.println(String.format("%s time: %s", threadName, (new Date().getTime()-startTime)));
        };
    }
}
