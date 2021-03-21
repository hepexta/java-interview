package com.hepexta.interview.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonChildTest {

    @Test
    public void commonChild() {
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
        assertEquals(2, CommonChild.commonChild("ABCDEF", "FBDAMN"));
        assertEquals(3, CommonChild.commonChild("FABCDEF", "FBDAMNS"));
    }
}
