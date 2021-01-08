package com.hepexta.interview;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CollisionsCountTest {

    @Test
    public void collision() {
        assertEquals(4, CollisionsCount.collision(Arrays.asList(12, 3, 22, 5, 1, 2), 5));
    }
}