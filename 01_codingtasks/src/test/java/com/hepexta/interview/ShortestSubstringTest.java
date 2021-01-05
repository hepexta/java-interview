package com.hepexta.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestSubstringTest {

    @Test
    public void shortest() {
        assertEquals(13, ShortestSubstring.shortest("asdfkjeghfalawefhaef"));
    }
}