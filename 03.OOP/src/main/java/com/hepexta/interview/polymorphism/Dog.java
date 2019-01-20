package com.hepexta.interview.polymorphism;

public class Dog extends Animal {
    @Override
    public String eat() {
        return "Bone";
    }

    @Override
    public String say() {
        return "Waw";
    }
}
