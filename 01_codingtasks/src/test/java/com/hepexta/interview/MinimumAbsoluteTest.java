package com.hepexta.interview;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumAbsoluteTest {

    @Test
    public void minimumAbsolute() {
        assertEquals(1, MinimumAbsolute.minimumAbsolute(Arrays.asList(5, 9, 6, 3, 1, 7)));
        assertEquals(1, MinimumAbsolute.minimumAbsolute(new int[]{5, 9, 6, 3, 1, 7}));
    }
}