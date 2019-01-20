package com.hepexta.interview.inheritance;

public class Aggregation {

    private PorscheCar porscheCar = new PorscheCar();

    public void print() {
        System.out.println(porscheCar.name());
    }
}
