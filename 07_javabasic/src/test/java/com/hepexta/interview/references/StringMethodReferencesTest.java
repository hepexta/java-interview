package com.hepexta.interview.references;

import org.junit.Assert;
import org.junit.Test;

public class StringMethodReferencesTest {

    @Test
    public void test_passReference() {
        String original = "ab";
        String x = new String(original);
        change(x); // Not changed
        Assert.assertEquals(original, x);
    }

    @Test
    public void test_stringIntern() {
        String original = "ab";
        String x = original.intern();
        Assert.assertEquals(original, x);
    }

    private static void change(String x) {
        x = "cd";
    }
}
