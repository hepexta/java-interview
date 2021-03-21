package com.hepexta.interview;

import java.util.*;
import java.util.stream.Stream;

public class ShortestSubstring {

    public static int shortest(String str) {
        int result = 0;
        if (str != null && !str.isEmpty()) {
            HashSet<Character> set = getUniqueChars(str);

            OptionalInt testing = Stream.of(str)
                    .flatMap(s -> substrings(s).stream())
                    .distinct()
                    .filter(s -> isAllContains(set, s))
                    .mapToInt(String::length)
                    .min();
            result = testing.getAsInt();
        }
        return result;
    }

    private static HashSet<Character> getUniqueChars(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }

    private static boolean isAllContains(HashSet<Character> set, String s) {
        for (Character character : set) {
            if (!s.contains(character.toString())) {
                return false;
            }
        }
        return true;
    }

    public static List<String> substrings(final String source) {
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            for (int j = i + 1; j <= source.length(); j++) {
                list.add(source.substring(i, j));
            }
        }
        return list;
    }

}
