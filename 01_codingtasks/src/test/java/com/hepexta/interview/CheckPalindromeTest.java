package com.hepexta.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPalindromeTest {
    @Test
    public void testIsPalindrome() {
        assertTrue(CheckPalindrome.isPalindromeUsingStream("asdsa"));
        assertTrue(CheckPalindrome.isPalindromeUsingStream("asddsa"));
        assertFalse(CheckPalindrome.isPalindromeUsingStream("asdasd"));

        assertTrue(CheckPalindrome.isPalindromeUsingReverse("asdsa"));
        assertTrue(CheckPalindrome.isPalindromeUsingReverse("asddsa"));
        assertFalse(CheckPalindrome.isPalindromeUsingReverse("asdasd"));
    }
}