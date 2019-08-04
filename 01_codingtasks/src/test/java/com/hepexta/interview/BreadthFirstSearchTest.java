package com.hepexta.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class BreadthFirstSearchTest {

    @Test
    public void bfs_test() {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        Assert.assertEquals("0 1 2 3", BreadthFirstSearch.bfs(0, g.getAdj(), new boolean[4]));
        Assert.assertEquals("1 2 3", BreadthFirstSearch.bfs(1, g.getAdj(), new boolean[4]));
    }

    class Graph{
        private LinkedList<Integer> adj[]; //Adjacency Lists
        Graph(int v){
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        LinkedList<Integer>[] getAdj() {
            return adj;
        }
    }
}
