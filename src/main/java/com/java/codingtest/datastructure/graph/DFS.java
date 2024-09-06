package com.java.codingtest.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    static HashMap<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, List.of(1, 3));
        adjacencyList.put(1, List.of(0, 2));
        adjacencyList.put(2, List.of(1));
        adjacencyList.put(3, List.of(0));
    }

    public static ArrayList<Integer> dfsWithArrayAdjacencyList(Map<Integer, List<Integer>> adjacencyList, int currentVertex) {
        visited.put(currentVertex, true);
        for (Integer edged : adjacencyList.get(currentVertex)) {
            if (!visited.containsKey(edged))
                dfsWithArrayAdjacencyList(adjacencyList, currentVertex);
        }

    }
}
