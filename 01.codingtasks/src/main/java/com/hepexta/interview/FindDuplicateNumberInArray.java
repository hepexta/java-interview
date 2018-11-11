package com.hepexta.interview;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumberInArray {

    public static int getDuplicated(Integer[] arr) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (Integer integer : arr) {
            if (!set.add(integer)){
                result = integer;
                break;
            }
        }
        return result;
    }
}
