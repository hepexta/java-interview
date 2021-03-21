package com.hepexta.interview.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayDS {

    private static final int HOUR_GLASS_RANGE = 3;

    public static void main(String[] args) {
        int i = 5;
        String s1 = "";
        String s2 = new String("");
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        Stream<int[]> stream1 = Arrays.stream(arr);
        int[] flatArr = stream1
                .flatMapToInt(Arrays::stream)
                .toArray();
        int size = arr.length;
        int step = 2* size + 2;
        for (int i = 0; i < flatArr.length - step; i++) {
            if ((i+2)%size==0 || (i+1)%size==0) continue;
            sum = Math.max(sum, countHourGlass(size, flatArr, i));
        }
        return sum;
    }

    private static int countHourGlass(int arrSize, int[] flatArr, int i) {
        int step = 2 * arrSize;
        int middlePoint = i + 1 + arrSize;
        int sum = IntStream
                .range(0, HOUR_GLASS_RANGE)
                .map(x -> flatArr[i + x])
                .sum();
        sum += IntStream
                .range(0, HOUR_GLASS_RANGE)
                .map(x -> flatArr[i + step + x])
                .sum();
        sum += flatArr[middlePoint];
        return sum;
    }

}
