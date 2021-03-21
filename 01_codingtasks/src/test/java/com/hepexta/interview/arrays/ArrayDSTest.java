package com.hepexta.interview.arrays;

import com.hepexta.interview.arrays.ArrayDS;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDSTest {

    @Test
    public void hourglassSum() {
        assertEquals(33, ArrayDS.hourglassSum(
                new int[][]{{3, 7, -3, 0, 1, 8},
                            {1, -4, -7, -8, -6, 5},
                            {-8, 1, 3, 3, 5, 7},
                            {-2, 4, 3, 1, 2, 7},
                            {2, 4, -5, 1, 8, 4},
                            {5, -7, 6, 5, 2, 8}}
                            ));
        assertEquals(28, ArrayDS.hourglassSum(
                new int[][]{{-9, -9, -9, 1, 1, 1},
                        {0, -9, 0, 4, 3, 2},
                        {-9, -9, -9, 1, 2, 3},
                        {0, 0, 8, 6, 6, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, 1, 2, 4, 0}}
        ));
    }
}
