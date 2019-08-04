package com.hepexta.interview.polymorphism;

import org.junit.Assert;
import org.junit.Test;

public class PolymorphismTest {

    @Test
    public void polymorphismTest() {
        Animal animal = new Animal();
        Assert.assertNull(animal.eat());
        Assert.assertNull(animal.say());

        animal = new Cat();
        Assert.assertEquals("Milk", animal.eat());
        Assert.assertEquals("Meow", animal.say());

        animal = new Dog();
        Assert.assertEquals("Bone", animal.eat());
        Assert.assertEquals("Waw", animal.say());
    }
}
