package com.hepexta.interview.datastructure;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void testQueue_isEmpty() {
        Queue queue = new Queue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueue_enQueue() {
        Queue queue = new Queue();
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void testQueue_deQueue() {
        Queue queue = new Queue();
        int x = 1;
        queue.enQueue(x);
        queue.enQueue(x + 1);
        Assert.assertEquals(x, queue.deQueue());
        Assert.assertFalse(queue.isEmpty());
    }
}
