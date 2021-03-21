package com.hepexta.interview.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicatesInTwoArraysTest {

    @Test
    public void findDuplicates() {
        assertArrayEquals(new int[]{3,5,11}, FindDuplicatesInTwoArrays.findDuplicates(new int[]{1,3,5,8,11}, new int[]{2,3,5,9,11,13}));
    }
}
