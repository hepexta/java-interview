package com.hepexta.interview;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BalancedOrNotTest {

    @Test
    public void balancedOrNot() {
        assertArrayEquals(Arrays.asList(1, 1, 1, 1, 0, 0).toArray(), BalancedOrNot.balancedOrNot2(
                Arrays.asList("<<>>", "<>", "<><>", ">>", "<<>", "><><"),
                Arrays.asList(0, 1, 2, 2, 2, 2)).toArray());
    }
}