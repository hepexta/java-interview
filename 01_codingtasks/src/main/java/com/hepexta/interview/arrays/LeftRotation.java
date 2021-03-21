package com.hepexta.interview.arrays;

import java.util.stream.IntStream;

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        IntStream.range(0, d).forEach(x -> {
            int temp = a[0];
            System.arraycopy(a, 1, a, 0, a.length-1);
            a[a.length-1] = temp;
        });
        return a;
    }
}
