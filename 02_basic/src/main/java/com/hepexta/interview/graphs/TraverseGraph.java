package com.hepexta.interview.graphs;

import com.hepexta.interview.graphs.simple.Edge;
import com.hepexta.interview.graphs.simple.Graph;
import com.hepexta.interview.graphs.simple.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class TraverseGraph {

    public static void main(String[] args) {
        Graph graph = prepareGraph();
        printGraph(graph);
        System.out.println(searchGraph(graph, 3, 4));
        System.out.println(searchGraph(graph, 0, 2));
    }

    private static Graph prepareGraph() {
        Graph graph = new Graph();
        Node node0 = getNode("0");
        Node node1 = getNode("1");
        Node node2 = getNode("2");
        Node node3 = getNode("3");
        Node node4 = getNode("4");

        Edge edge0_1 = new Edge(node0, node1);
        Edge edge0_4 = new Edge(node0, node4);
        Edge edge1_4 = new Edge(node1, node4);
        Edge edge1_3 = new Edge(node1, node3);
        Edge edge1_2 = new Edge(node1, node2);
        Edge edge2_3 = new Edge(node2, node3);
        Edge edge3_4 = new Edge(node3, node4);

        ArrayList<Edge> connections0 = getEdges(edge0_1, edge0_4);
        ArrayList<Edge> connections1 = getEdges(edge0_1, edge1_2, edge1_3, edge1_4);
        ArrayList<Edge> connections2 = getEdges(edge1_2, edge2_3);
        ArrayList<Edge> connections3 = getEdges(edge1_3, edge2_3);
        ArrayList<Edge> connections4 = getEdges(edge1_4, edge0_4, edge3_4);

        node0.connections = connections0;
        node1.connections = connections1;
        node2.connections = connections2;
        node3.connections = connections3;
        node4.connections = connections4;

        ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(node0, node1, node2, node3, node4));
        graph.setNodes(nodes);

        return graph;
    }

    private static void printGraph(Graph graph) {
        for (Node node : graph.getNodes()) {
            System.out.println(node);
        }
    }

    private static boolean searchGraph(Graph graph, int src, int dest) {
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.connections) {
                if ((edge.getStart().name.equals(String.valueOf(src))
                        && edge.getEnd().name.equals(String.valueOf(dest)))
                        || (edge.getStart().name.equals(String.valueOf(dest))
                        && edge.getEnd().name.equals(String.valueOf(src)))) {
                    System.out.println(edge);
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<Edge> getEdges(Edge... edges) {
        return new ArrayList<>(Arrays.asList(edges));
    }

    private static Node getNode(String name) {
        Node node = new Node();
        node.name = name;
        return node;
    }

}
