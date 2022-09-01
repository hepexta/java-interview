package com.hepexta.interview.concurrency.collections;

import java.util.Vector;

// @NotThreadSafe
public class VectorExample {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        new Thread(() -> getLast(vector)).start();
        new Thread(() -> deleteLast(vector)).start();
    }

    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }
    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
