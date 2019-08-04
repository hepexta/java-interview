package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

public class LeetCodeWordLadderTest {

    @Test
    public void leetCodeTest() {
        String start = "hit";
        String end = "cog";
        String[] dict = new String[]{"hot","dot","dog","lot","log"};

        Assert.assertEquals(5, LeetCodeWordLadder.leetCode(start, end, dict));
    }
}
