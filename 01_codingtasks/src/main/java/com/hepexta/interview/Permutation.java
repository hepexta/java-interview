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

    static void CombinationRepetitionUtil(int chosen[], int arr[],
                                          int index, int r, int start, int end) {
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.printf("%d ;", arr[chosen[i]]);
            }
            System.out.printf("\n");
            return;
        }
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            CombinationRepetitionUtil(chosen, arr, index + 1, r, i, end);
        }
        return;
    }

    static void CombinationRepetition(int arr[], int n, int r) {
        int chosen[] = new int[r + 1];
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;
        int r = 3;
        CombinationRepetition(arr, n, r);
    }
}
