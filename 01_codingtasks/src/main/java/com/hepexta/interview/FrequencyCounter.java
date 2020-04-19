package com.hepexta.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Count all characters in the input stream
 */
public class FrequencyCounter {

    public Map<Character, Integer> count(String input) {
        HashMap<Character, Integer> result = new HashMap<>();
        if (input != null){
            for (int i=0;i<input.length();i++) {
                Integer integer = result.get(input.charAt(i));
                result.put(input.charAt(i), integer != null ? integer+1 : 1);
            }
        }
        return result;
    }

    public Map<Object, Long> count(Stream<Character> characterStream) {
        return characterStream.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }
}
