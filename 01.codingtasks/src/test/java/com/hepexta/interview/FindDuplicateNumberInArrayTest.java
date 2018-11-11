package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumberInArrayTest {

    @Test
    public void test_findDuplicateNumberInArray() {
        Integer[] arr = new Integer[]{10, 2, 3, 9, 4, 7, 8, 9, 5};

        Assert.assertEquals(9, FindDuplicateNumberInArray.getDuplicated(arr));
    }
}
