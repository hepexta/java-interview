package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArraysTests {

    @Test
    public void test_mergeSortArrays() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 7, 9};
        Integer[] arr2 = new Integer[]{1, 4, 8, 9, 10, 15};
        Integer[] expected = new Integer[]{1, 1, 2, 3, 4, 4, 7, 8, 9, 9, 10, 15};

        Assert.assertArrayEquals(expected, MergeSortedArrays.sort(arr1, arr2));
    }

    @Test
    public void test_mergeSortArrays2() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 7, 9};
        Integer[] arr2 = new Integer[]{1, 4, 8, 9, 10, 15};
        Integer[] expected = new Integer[]{1, 1, 2, 3, 4, 4, 7, 8, 9, 9, 10, 15};

      //  Assert.assertArrayEquals(expected, MergeSortedArrays.sort_oneLoop(arr1, arr2));
    }
}
