package com.hepexta.interview.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeftRotationTest {

    @Test
    public void rotLeft() {
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, LeftRotation.rotLeft(new int[]{1, 2, 3, 4, 5}, 4));
        assertArrayEquals(new int[]{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60}, LeftRotation.rotLeft(new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97}, 13));
        ;
    }
}
