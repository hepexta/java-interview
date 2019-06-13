package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarrayTest {

    @Test
    public void test_nSquare() {
        int[] nums = new int[]{-2, 7, 11, 15};
        Assert.assertEquals(33, MaximumSubarray.getMaxSubArrayNSquare(nums));

        nums = new int[]{2, 7, -11, -15};
        Assert.assertEquals(9, MaximumSubarray.getMaxSubArrayNSquare(nums));

        nums = new int[]{2, -7, 11, -15};
        Assert.assertEquals(11, MaximumSubarray.getMaxSubArrayNSquare(nums));

        nums = new int[]{2, -7, 15, -11, 99};
        Assert.assertEquals(103, MaximumSubarray.getMaxSubArrayNSquare(nums));

        nums = new int[]{-2, -7, -15, -11, -99};
        Assert.assertEquals(-2, MaximumSubarray.getMaxSubArrayNSquare(nums));
    }
}
