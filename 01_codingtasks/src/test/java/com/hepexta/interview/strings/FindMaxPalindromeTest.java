package com.hepexta.interview.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxPalindromeTest {

    @Test
    public void findMaxPalindrome() {
        assertEquals("SSDSS", FindMaxPalindrome.findMaxPalindrome("AKJDSLKJSSDSS"));
        assertEquals("F", FindMaxPalindrome.findMaxPalindrome("ABSDEF"));
        assertEquals("SDS", FindMaxPalindrome.findMaxPalindrome("ABSDSEF"));
    }

    @Test
    public void findMaxPalindromeStream() {
        assertEquals("SSDSS", FindMaxPalindrome.findMaxPalindromeStream("AKJDSLKJSSDSS"));
        assertEquals("A", FindMaxPalindrome.findMaxPalindromeStream("ABSDEF"));
        assertEquals("SDS", FindMaxPalindrome.findMaxPalindromeStream("ABSDSEF"));
    }
}
