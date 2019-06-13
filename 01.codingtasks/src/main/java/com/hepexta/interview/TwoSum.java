package com.hepexta.interview;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //O((N^2)/2)
    public static int[] getIndexesForTarget(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i=0;i<nums.length;i++) {
            ints[0]=i;
            for (int j=i+1;j<nums.length;j++) {
                if(nums[i]+nums[j]==target){
                    ints[1]=j;
                    return ints;
                }
            }
        }
        return ints;
    }

    public static int[] getIndexesRecursion(int[] nums, int start_i, int target) {
        int[] ints = new int[2];
        ints[0]=start_i;
        for (int i=start_i;i<nums.length;i++) {
            if (nums[start_i] + nums[i] == target) {
                ints[1] = i;
                return ints;
            }
        }
        return getIndexesRecursion(nums, ++start_i, target);
    }

    public static int[] getIndexesMap(int[] nums, int target) {
        int[] ints = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
            if (map.get(target-nums[i])!=null){
                ints[0]=map.get(target-nums[i]);
                ints[1]=i;
                return ints;
            }
        }
        return ints;
    }

    public static int[] getIndexesTwoPoints(int[] nums, int target) {
        int[] ints = new int[2];
        int i=0;
        int j=nums.length-1;
        while (nums[j]+nums[i]!=target){
            if(j>i){
                j--;
            }
            else {
                i++;
                j=nums.length-1;
            }
        }
        ints[0]=i;
        ints[1]=j;
        return ints;
    }
}
