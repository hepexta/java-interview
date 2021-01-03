package com.hepexta.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PermutationTest {

    @Test
    public void generatePermutations() {
        List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
        assertArrayEquals(expected.toArray(), Permutation.generatePermutations("ABC").toArray());
    }

    @Test
    public void generatePermutationsWithLimit() {
        List<String> expected = Arrays.asList("AB", "AC", "BA", "BC", "CA", "CB");
        assertArrayEquals(expected.toArray(), Permutation.generatePermutations("ABC", 2).toArray());
    }
}