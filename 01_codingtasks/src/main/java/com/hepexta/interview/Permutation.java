package com.hepexta.interview;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<String> generatePermutations(String string){
        int end = string.length();
        return generatePermutation(string, 0, end, end);
    }

    public static List<String> generatePermutations(String string, int size){
        int end = string.length();
        return generatePermutation(string, 0, end, size);
    }

    private static List<String> generatePermutation(String string, int start, int end, int size) {
        List<String> list = new ArrayList<>();
        if (start == end-1) {
            list.add(string.substring(0, size));
        }
        else {
            for (int i = start; i < end; i++) {
                string = swapString(string, start, i);
                list.addAll(generatePermutation(string, start+1, end, size));
            }
        }

        return list;
    }

    private static String swapString(String string, int start, int end) {
        char[] arr = string.toCharArray();
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        return String.valueOf(arr);
    }
}
