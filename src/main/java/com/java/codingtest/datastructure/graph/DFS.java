package com.java.codingtest.datastructure.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    // static HashMap<Integer, Boolean> visited = new HashMap<>();

    static boolean[][] visited;
    static int[][] grid;

    // 이동을 위한 경로 : 위, 오른쪽, 아래, 왼쪽 순 (시계방향)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        graph.put(0, List.of(1, 3));
//        graph.put(1, List.of(0, 2));
//        graph.put(2, List.of(1));
//        graph.put(3, List.of(0));
//        dfsWithArrayAdjacencyList(graph, 0); // 인접 행렬로 탐색하는 방법

        // 암시적 그래프로 탐색하는 방법
        grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        visited = new boolean[grid.length][grid[0].length]; // 배열의 모든 요소를 false로 초기화
        dfsWithImplicitGraph(0, 0);
    }

    /*
    public static void dfsWithArrayAdjacencyList(Map<Integer, List<Integer>> graph, int currentVertex) {
        visited.put(currentVertex, true);
        for (Integer edged : graph.get(currentVertex)) {
            if (!visited.containsKey(edged))
                dfsWithArrayAdjacencyList(graph, currentVertex);
        }
    }
     */

    /**
     * 암시적 그래프가 주어졌을 때 DFS 탐색
     */
    public static void dfsWithImplicitGraph(int row, int col) {
        visited[row][col] = true; // 노드를 방문 처리
        for (int i = 0; i < 4; i++) { // {row, col}을 기준으로 상하좌우 4개의 노드를 탐색하기 위함
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if(isValidNode(nextRow, nextCol)) { // {nextRow, nextCol} 값이 유효하며 인접 노드가 있는 경우
                if(!visited[nextRow][nextCol]) dfsWithImplicitGraph(nextRow, nextCol); // 아직 방문되지 않았으면 재귀로 더 깊게 탐색 수행
            }
        }
    }

    public static boolean isValidNode(int row, int col) {
        return row >= 0 && row < grid.length // row의 유효성 확인 : 0 <= (행 좌표) < grid의 세로 길이(=행 크기)
                && col >= 0 && col < grid[0].length // col의 유효성 확인 : 0 <= (열 좌표) < grid의 가로 길이(=열 크기)
                && grid[row][col] == 1; // grid[row][col]이 다른 노드와 연결된 노드인지 확인
    }
}
