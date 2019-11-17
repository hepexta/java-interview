package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

public class FrequencyCounterTest {

    @Test
    public void givenStream_whenCount_thenResult() {
        FrequencyCounter counter = new FrequencyCounter();
        Stream<Character> srt = "qweqweqwe".chars().mapToObj(c -> (char) c);

        Map<Object, Long> result = counter.count(srt);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(Long.valueOf(3), result.get('q'));
        Assert.assertEquals(Long.valueOf(3), result.get('w'));
        Assert.assertEquals(Long.valueOf(3), result.get('e'));
    }

    @Test
    public void happyPathTest() {
        FrequencyCounter counter = new FrequencyCounter();
        String srt = "qweqweqwe";

        Map<Character, Integer> result = counter.count(srt);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(Integer.valueOf(3), result.get('q'));
        Assert.assertEquals(Integer.valueOf(3), result.get('w'));
        Assert.assertEquals(Integer.valueOf(3), result.get('e'));
    }

    @Test
    public void givenNullStr_whenCount_thenEmptyMap() {
        FrequencyCounter counter = new FrequencyCounter();
        String srt = null;

        Map<Character, Integer> result = counter.count(srt);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void givenEmtyStr_whenCount_thenEmptyMap() {
        FrequencyCounter counter = new FrequencyCounter();
        String srt = "";
        Map<Character, Integer> result = counter.count(srt);
        Assert.assertEquals(0, result.size());
    }

}
