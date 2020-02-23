package com.hepexta.interview.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyWithMessageQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        demoWaitNotifyWithMessageQueue();
    }

    private static void demoWaitNotifyWithMessageQueue() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        MessageQueue messageQueue = new BrokenMessageQueue();
        //MessageQueue messageQueue = new MessageQueueWithLockConditions();
        //MessageQueue messageQueue = new MessageQueueWithWaitNotify();

        Runnable producer = () -> {
            String[] messages = { "Streets", " full of water.", " Please", "advise." };
            for (String message : messages) {
                System.out.format("%s sending >> %s%n", Thread.currentThread().getName(), message);
                messageQueue.send(message);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 4; i++) {
                String message = messageQueue.receive();
                System.out.format("%s received << %s%n", Thread.currentThread().getName(), message);
                try {
                    TimeUnit.MILLISECONDS.sleep(0);
                } catch (InterruptedException e) {
                }
            }
        };

        service.submit(producer);
        service.submit(consumer);

        service.awaitTermination(5000, TimeUnit.MILLISECONDS);

    }

    private static class BrokenMessageQueue implements MessageQueue {

        private final int capacity = 2;

        private final Queue<String> queue = new LinkedList<>();

        public void send(String message) {
            while (queue.size() == capacity) {
            }
            queue.add(message);
        }

        public String receive() {
            while (queue.size() == 0) {
            }
            String value = queue.poll();
            return value;
        }

    }

    private static class MessageQueueWithWaitNotify implements MessageQueue {

        private final int capacity = 2;

        private final Queue<String> queue = new LinkedList<>();

        public synchronized void send(String message) {
            while (queue.size() == capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            queue.add(message);
            notifyAll();
        }

        public synchronized String receive() {
            while (queue.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            String value = queue.poll();
            notifyAll();
            return value;
        }

    }

    private static class MessageQueueWithLockConditions implements MessageQueue {

        private final int capacity = 2;

        private final Lock lock = new ReentrantLock();

        private final Condition queueNotFull = lock.newCondition();

        private final Condition queueNotEmpty = lock.newCondition();

        private final Queue<String> queue = new LinkedList<>();

        public void send(String message) {
            lock.lock();
            try {
                while (queue.size() == capacity) {
                    try {
                        queueNotFull.await();
                    } catch (InterruptedException e) {
                    }
                }
                queue.add(message);
                queueNotEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public String receive() {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    try {
                        queueNotEmpty.await();
                    } catch (InterruptedException e) {
                    }
                }
                String value = queue.poll();
                queueNotFull.signalAll();
                return value;
            } finally {
                lock.unlock();
            }
        }

    }

    public interface MessageQueue {
        void send(String message);
        String receive();
    }

}
