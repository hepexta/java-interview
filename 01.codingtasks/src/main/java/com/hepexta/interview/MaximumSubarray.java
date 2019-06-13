package com.hepexta.interview;

public class MaximumSubarray {

    public static int getMaxSubArrayNSquare(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            for (int j=i;j<nums.length;j++){
                if (i!=j)
                    num+=nums[j];
                result = result < num ? num : result;
            }
        }
        return result;
    }
}
