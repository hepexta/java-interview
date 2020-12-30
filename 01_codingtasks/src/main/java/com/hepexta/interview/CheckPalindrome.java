package com.hepexta.interview;

import java.util.stream.IntStream;


public class CheckPalindrome {

    public static boolean isPalindromeUsingStream(String string) {
        return IntStream.range(0, string.length()/2).noneMatch(i -> string.charAt(i) != string.charAt(string.length() - i - 1));
    }

    public static boolean isPalindromeUsingReverse(String string) {
        return string.equals(reverse(string));
    }

    private static String reverse(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.toCharArray());
        return sb.reverse().toString();
    }
}