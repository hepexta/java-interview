package com.hepexta.interview.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTests {

    @Test
    public void testBubbleSort_worst() {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort bubbleSort = new BubbleSort();
        Assert.assertEquals(45, bubbleSort.sort(arr));
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSort_normal() {
        int[] arr = new int[]{2, 1, 4, 3, 5, 6, 8, 7, 0, 9};
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort bubbleSort = new BubbleSort();
        Assert.assertEquals(11, bubbleSort.sort(arr));
        Assert.assertArrayEquals(expected, arr);
    }

}
