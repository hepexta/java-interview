package com.hepexta.interview.datastructure;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testStack_isEmpty() {
        Stack stack = new Stack();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testStack_push() {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testStack_pop() {
        Stack stack = new Stack();
        int x = 0;
        stack.push(x);
        Assert.assertEquals(x, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }
}
