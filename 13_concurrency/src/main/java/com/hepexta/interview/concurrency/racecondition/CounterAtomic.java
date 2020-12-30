package com.hepexta.interview.concurrency.racecondition;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic implements Counter {

    private AtomicLong count = new AtomicLong(0);

    public long incAndGet(){
        return count.incrementAndGet();
    }

    public long get(){
        return count.get();
    }
}
