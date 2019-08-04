package com.hepexta.interview.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test_capacity() {
        HashMap map = new HashMap();
        Assert.assertEquals(16, DEFAULT_INITIAL_CAPACITY);
        Assert.assertEquals(1073741824, MAXIMUM_CAPACITY);

        Assert.assertEquals(16, tableSizeFor(10));
        Assert.assertEquals(128, tableSizeFor(100));
        Assert.assertEquals(1024, tableSizeFor(1000));
    }

    @Test
    public void test_Hash() {
        HashMap map = new HashMap();
        Assert.assertEquals(112382, hash("qwe"));
        Assert.assertEquals(96883, hash("asd"));
        Assert.assertEquals(121060, hash("zxc"));
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int hash(Object key) {
        int h;
        int h1 = getHashCode(key);
        System.out.println("hashCode="+h1);
        int i = h = h1;
        int i1 = getI16(h);
        System.out.println("getI16="+i1);
        return getPow(i, i1);
    }

    private static int getPow(int i, int i1) {
        return i ^ i1;
    }

    private static int getI16(int h) {
        return h >>> 16;
    }

    private static int getHashCode(Object key) {
        return key.hashCode();
    }


}
