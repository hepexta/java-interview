package com.hepexta.interview.polymorphism;

public class Cat extends Animal {
    @Override
    public String eat() {
        return "Milk";
    }

    @Override
    public String say() {
        return "Meow";
    }
}
