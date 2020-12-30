package com.hepexta.interview.concurrency.racecondition;

public class CounterSynchronized implements Counter {

    private long count = 0;

    public long incAndGet(){
        synchronized (this){
            count++;
            return count;
        }

    }

    public long get(){
        synchronized (this){
            return count;
        }
    }

}
