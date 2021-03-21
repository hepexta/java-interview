package com.hepexta.interview;

import java.util.ArrayList;
import java.util.List;

public class BalancedOrNot {

    public static List<Integer> balancedOrNot2(List<String> expressions, List<Integer> maxReplacements) {
        final ArrayList<Integer> result = new ArrayList<>();

        final int[] leftOpened = {0};
        final int[] rightOpened = {0};

        for (int i = 0; i < expressions.size(); i++) {
            final String expression = expressions.get(i);
            final Integer maxReplacement = maxReplacements.get(i);
            leftOpened[0] = 0;
            rightOpened[0] = 0;

            expression
                    .chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> balance(leftOpened, rightOpened, c));

            if (leftOpened[0] > 0) {
                result.add(0);
                continue;
            }

            if (rightOpened[0] > maxReplacement) {
                result.add(0);
                continue;
            }

            result.add(1);
        }

        return result;
    }

    private static void balance(int[] leftOpened, int[] rightOpened, Character c) {
        if (c == '<') {
            leftOpened[0]++;
            return;
        }

        if (c == '>') {
            if (leftOpened[0] > 0) {
                leftOpened[0]--;
                return;
            }

            rightOpened[0]++;
        }
    }

}

