package com.hepexta.interview;

import java.util.Arrays;
import java.util.List;

public class MinimumAbsolute {

    public static int minimumAbsolute(List<Integer> list){
        final int[] sum = {Integer.MAX_VALUE};
        if (list != null) {
            list.stream().sorted().reduce((int1, int2) -> calcMin(sum, int1, int2));
        }
        return sum[0];
    }

    public static int minimumAbsolute(int[] arr){
        final int[] sum = {Integer.MAX_VALUE};
        if (arr != null) {
            Arrays.stream(arr).sorted().reduce((int1, int2) -> calcMin(sum, int1, int2));
        }
        return sum[0];
    }

    private static int calcMin(int[] sum, int int1, int int2) {
        sum[0] = Math.min(Math.abs(int1 - int2), sum[0]);
        return int2;
    }
}
