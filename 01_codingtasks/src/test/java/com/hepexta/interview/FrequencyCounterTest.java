package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
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
    public void givenStream_whenCount_thenResult_time() {
      /*  Assert.assertTrue(getStreamExecutionTime(10000)>getStringExecutionTime(10000));
        Assert.assertTrue(getStreamExecutionTime(100000)>getStringExecutionTime(100000));
        Assert.assertTrue(getStreamExecutionTime(1000000)>getStringExecutionTime(1000000));
        Assert.assertFalse(getStreamExecutionTime(10000000)>getStringExecutionTime(10000000));
     */   Assert.assertFalse(getStreamExecutionTime(30000000)>getStringExecutionTime(30000000));
    }

    private long getStringExecutionTime(int qty) {
        StringBuilder str = getStringBuilder(qty);
        FrequencyCounter counter = new FrequencyCounter();
        long time;
        time = new Date().getTime();
        counter.count(str.toString());
        long stringExecutionTime = new Date().getTime() - time;
        System.out.println(stringExecutionTime);
        return stringExecutionTime;
    }

    private StringBuilder getStringBuilder(int qty) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i< qty; i++){
            str.append(i);
        }
        return str;
    }

    private long getStreamExecutionTime(int qty) {
        StringBuilder str = getStringBuilder(qty);
        FrequencyCounter counter = new FrequencyCounter();
        Stream<Character> stream = str.toString().chars().mapToObj(c -> (char) c);
        long time = new Date().getTime();
        counter.count(stream);
        long streamExecutionTime = new Date().getTime() - time;
        System.out.println(streamExecutionTime);
        return streamExecutionTime;
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
