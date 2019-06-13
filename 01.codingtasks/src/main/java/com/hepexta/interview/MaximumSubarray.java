package com.hepexta.interview;

public class MaximumSubarray {

    //O(N)
    public static int getIndexesForTarget(int[] nums) {
        int result = 0;
        int storyPointer = 0;
        for (int num : nums) {
            storyPointer+=num;
            if (storyPointer<0) {
                storyPointer = 0;
            }
            if(result < storyPointer) {
                result = storyPointer;
            }
        }
        return result;
    }
}
