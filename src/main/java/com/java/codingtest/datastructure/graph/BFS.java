package com.java.codingtest.datastructure.graph;

import java.util.*;

/**
 * Graph = G(V,E)
 * 그래프 = 정점(vetex)과 간선(edge)의 집합으로 정점 사이의 연결 관계를 나타내는 자료구조
 * <p>
 * 그래프의 종류
 * 방향그래프 vs 무향그래프 == 정점에 연결된 간선의 방향 유무에 따라 나누는 방식
 * 다중그래프 vs 단순그래프 == 두 정점 사이에 연결된 간선의 개수에 따라 나누는 방식
 * 가중치그래프 (다익스트라) == 간선마다의 가중치가 존재하는 그래프
 * <p>
 * 표현 방법
 * 1) 인접리스트   : vertex:[connectedVertex1, connectedVertex2, .. ] 형태로 인접한 정점 리스트를 HashMap에 저장
 * 2) 인접행렬    : array[i][j] 형태, 각 배열 요소에 i, j 버텍스 간의 간선 개수를 배열로 표현
 * 3) 암시적그래프 : array[i][j] 형태, 직접 간선의 관계를 표현하지 않지만 한 요소를 정점으로 보고 연결됨=1, 간선없음=0으로 표현 (중요)
 * <p>
 * 순회 방법
 * 1) BFS : 기준이 되는 정점에 가까운 순으로 너비 기준 탐색 (가까운 순서대로 탐색 후 그 다음 가까운 순서를 순회)
 * 2) DFS : 기준이 되는 정점에 연결된 정점을 깊이 기준 탐색 (파고파고 끝까지 들어간 뒤 다음 순회)
 */
public class BFS {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, List.of(1, 3));
        adjacencyList.put(1, List.of(0, 2));
        adjacencyList.put(2, List.of(1));
        adjacencyList.put(3, List.of(0));
        ArrayList<Integer> visited = bfsWithArrayAdjacencyList(adjacencyList, 0);
    }

    /**
     * 인접리스트를 이용한 BFS 구현
     * @param adjacencyList
     */
    public static ArrayList<Integer> bfsWithArrayAdjacencyList(Map<Integer, List<Integer>> adjacencyList, int start) {
        ArrayList<Integer> visited = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int edgedVertex : adjacencyList.get(vertex)) {
                queue.offer(edgedVertex);
                if(!visited.contains(edgedVertex)) visited.add(edgedVertex);
            }
        }
        return visited;
    }
}
