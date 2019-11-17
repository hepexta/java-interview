package com.hepexta.interview.concurrency;

public class WaitNotify {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted "+ e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted "+ e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();

        Thread t1 = new Thread(() -> {
            waitNotify.send("packet1");
            waitNotify.send("packet2");
            waitNotify.send("packet3");
        });

        Thread t2 = new Thread(() -> {
            System.out.println(waitNotify.receive());
            System.out.println(waitNotify.receive());
            System.out.println(waitNotify.receive());
        });

        t1.start();
        t2.start();
    }
}
