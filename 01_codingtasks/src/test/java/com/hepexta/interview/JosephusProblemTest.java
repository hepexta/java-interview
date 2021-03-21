package com.hepexta.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class JosephusProblemTest {

    @Test
    public void josephus() {
        assertEquals(1, JosephusProblem.josephus(1, 1));
        assertEquals(2, JosephusProblem.josephus(2, 1));
        assertEquals(4, JosephusProblem.josephus(7, 3));
    }
}
