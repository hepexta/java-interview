package com.hepexta.interview.graphs.simple;

import java.util.List;

public class Node {
    public String name;
    public List<Edge> connections;

    @Override
    public String toString() {
        return "Node{" + name + '\'' +
                ", connections=" + connections +
                '}';
    }
}
