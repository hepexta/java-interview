package com.hepexta.interview;

public class FibonacciNumbers {

    static int n1=0;
    static int n2=1;
    static int n3=0;

    public static void main(String[] args) {
        int count = 10;
        printFibonacciNumberRecursively(count-1);
    }

    private static void printFibonacciNumberRecursively(int count) {
        if (count>0){
            n3 = n1+n2;
            System.out.println(n3);
            n1=n2;
            n2=n3;
            printFibonacciNumberRecursively(--count);
        }
    }
}
