package com.hepexta.interview.datastructure;

public class Queue {

    private static final int MAX = 1000;
    private int top;
    private int a[] = new int[MAX]; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }

    Queue() {
        top = -1;
    }

    void enQueue(int x) {
        if (top == MAX) {
            System.out.println("Stack Overflow");
        } else {
            a[++top] = x;
        }
    }

    int deQueue() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            top--;
        }
        return a[0];
    }
}
