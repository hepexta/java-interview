package com.hepexta.interview;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class BreadthFirstSearch {

    public static String bfs(int s, LinkedList<Integer>[] adj, boolean[] visited) {
        //Add your code here.
        System.out.println(s);
        for (LinkedList<Integer> integers : adj) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        result.add(s);
        while (queue.size() != 0){
            s = queue.poll();
            LinkedList<Integer> integers = adj[s];
            for (Integer i : integers) {
                if (!visited[i]) {
                    queue.add(i);
                    result.add(i);
                    visited[i] = true;
                }
            }
        }

        return result.stream().map(Object::toString)
                .collect( Collectors.joining( " " ));
    }
}
