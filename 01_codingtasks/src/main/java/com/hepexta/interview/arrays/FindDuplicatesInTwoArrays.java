package com.hepexta.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInTwoArrays {

    static int[] findDuplicates(int[] arr1, int[] arr2) {

        List<Integer> result = new ArrayList();
        int i =0, j = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] == arr2[j]) {
                result.add(i);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

// [1,3,5,8,11] [2,3,5,9,11,13] => [3,5,11]

}
