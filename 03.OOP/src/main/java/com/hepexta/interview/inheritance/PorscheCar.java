package com.hepexta.interview.inheritance;

public class PorscheCar extends Car implements Luxury {

    @Override
    public String name() {
        return "Porsche";
    }

    @Override
    public int year() {
        return 2018;
    }

    @Override
    public String type() {
        return "3";
    }
}
