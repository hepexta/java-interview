package com.hepexta.interview.strings;

import java.util.*;

public class FindMaxPalindrome {

    public static String findMaxPalindrome(String input){

        TreeMap<Integer, String> strings = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <= input.length(); j++) {
                String substring = input.substring(i, j);
                if (isPalindrome(substring)){
                    strings.put(substring.length(), substring);
                }
            }
        }

        return strings.lastEntry().getValue();
    }

    public static String findMaxPalindromeStream(String input){

        Set<String> strings = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <= input.length(); j++) {
                strings.add(input.substring(i, j));
            }
        }

        Optional<String> max = strings.stream()
                .filter(x -> isPalindrome(x))
                .max(Comparator.comparingInt(x -> x.length()));
        return max.get();
    }

    private static boolean isPalindrome(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return x.equals(sb.reverse().toString());
    }
}
