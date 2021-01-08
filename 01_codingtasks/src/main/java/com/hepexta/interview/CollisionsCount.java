package com.hepexta.interview;

import java.util.List;

public class CollisionsCount {

    public static int collision(List<Integer> speed, int pos) {
        int result = 0;

        final Integer testSpeed = speed.get(pos);
        result += speed
                .subList(0, pos)
                .stream()
                .filter(s -> s > testSpeed)
                .count();

        result += speed
                .subList(pos + 1, speed.size())
                .stream()
                .filter(s -> s < testSpeed)
                .count();

        return result;
    }

}
