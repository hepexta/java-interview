package com.hepexta.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList();
        String hi = strings.stream()
                .filter(x -> true)
                .findAny()
                .orElse("Hi");

        IntUnaryOperator intUnaryOperator = (x) -> x+1;
        UnaryOperator<Integer> unaryOperator = (x) -> x+1;

        IntStream is = IntStream.of(1, 3, 5);
        int x = is.filter(i->i%2 == 0).average(); //1
        System.out.println(x);

        int y = is.filter( i->i%2 != 0 ).sum();//2
        System.out.println(y);

        is = IntStream.of(1, 3, 5, 9);
        int z = is.filter( i->i%3 != 0 ).count();//3
        System.out.println(z);
    }
}
