package com.hepexta.interview;

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
}
