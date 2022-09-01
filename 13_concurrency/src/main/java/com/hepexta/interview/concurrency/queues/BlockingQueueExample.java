package com.hepexta.interview.concurrency.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        blockingQueue.put("Hello");
        blockingQueue.offer ("World", 3, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.take());
    }
}
