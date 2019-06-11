package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, TwoSum.getIndexesForTarget(nums, target));

        target = 17;
        Assert.assertArrayEquals(new int[]{0, 3}, TwoSum.getIndexesForTarget(nums, target));

        target = 26;
        Assert.assertArrayEquals(new int[]{2, 3}, TwoSum.getIndexesForTarget(nums, target));
    }

    @Test
    public void test_recursion() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, TwoSum.getIndexesRecursion(nums, 0, target));

        target = 17;
        Assert.assertArrayEquals(new int[]{0, 3}, TwoSum.getIndexesRecursion(nums, 0, target));

        target = 26;
        Assert.assertArrayEquals(new int[]{2, 3}, TwoSum.getIndexesRecursion(nums, 0, target));
    }
}
