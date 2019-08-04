package com.hepexta.interview.inheritance;

import org.junit.Assert;
import org.junit.Test;

public class InheritanceTest {
    @Test
    public void inheritanceTest() {
        Car car = new PorscheCar();

        Assert.assertEquals("Porsche", car.name());
        Assert.assertEquals(2018, car.year());
        Assert.assertEquals("3", ((PorscheCar) car).type());
    }
}
