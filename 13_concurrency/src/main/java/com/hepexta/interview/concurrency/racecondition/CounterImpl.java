package com.hepexta.interview.concurrency.racecondition;

public class CounterImpl implements Counter {

    private long count = 0;

    public long incAndGet(){
        count++;
        return count;
    }

    public long get(){
        return count;
    }
}
