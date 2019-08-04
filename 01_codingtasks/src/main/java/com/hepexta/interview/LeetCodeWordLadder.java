package com.hepexta.interview;

import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary,
 * find the length of shortest transformation sequence from start to end,
 * such that only one letter can be changed at a time and
 * each intermediate word must exist in the dictionary
 *
 * String start = "hit";
 * String end = "cog";
 * String[] dict = new String[]{"hot","dot","dog","lot","log"};
 * */
public class LeetCodeWordLadder {

    class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static int leetCode(String start, String end, String[] dict) {
        LinkedList<WordNode> list = new LinkedList<>();

        return 0;
    }
}
