package com.java.codingtest.datastructure.graph;

import java.util.*;

public class BFS {
    static ArrayList<Integer> visitedNodeList = new ArrayList<>();
    static boolean[][] visitedNodeArray;
    static int[][] grid;

    // 이동을 위한 경로 : 위, 오른쪽, 아래, 왼쪽 순 (시계방향)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        /*
         인접리스트인 경우의 예시
         HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
         adjacencyList.put(0, List.of(1, 3));
         adjacencyList.put(1, List.of(0, 2));
         adjacencyList.put(2, List.of(1));
         adjacencyList.put(3, List.of(0));
         ArrayList<Integer> visited = bfsWithArrayAdjacencyList(adjacencyList, 0);
         */

        grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int row = grid.length;
        int col = grid[0].length;
        visitedNodeArray = new boolean[row][col];
        bfsWithImplicitGraph(0, 0);
    }

    /**
     * 인접리스트를 이용한 BFS 구현
     *
     * @param adjacencyList
     */
    public static void bfsWithArrayAdjacencyList(Map<Integer, List<Integer>> adjacencyList, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedNodeList.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int nextVertex : adjacencyList.get(vertex)) {
                if (!visitedNodeList.contains(nextVertex)) {
                    queue.offer(nextVertex);
                    visitedNodeList.add(nextVertex);
                }
            }
        }
    }

    /**
     * 암시적 그래프가 주어졌을 때 BFS 구현
     */
    public static void bfsWithImplicitGraph(int row, int col) {
        Queue<int[]> queue = new LinkedList<>(); // BFS 구현을 위한 큐 선언 및 초기화
        queue.offer(new int[]{row, col});
        visitedNodeArray[row][col] = true;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll(); // == {row, col} 형태의 노드의 좌표

            for (int i = 0; i < 4; i++) { // curNode를 기준으로 상하좌우에 있는 모든 노드를 탐색하기 위함
                int nextRow = curNode[0] + dr[i];
                int nextCol = curNode[1] + dc[i];
                if (isValidNode(nextRow, nextCol)) {
                    if (!visitedNodeArray[nextRow][nextCol]) { // 아직 탐색하지 않은 노드라면 큐와 visited에 추가
                        queue.offer(new int[]{nextRow, nextCol});
                        visitedNodeArray[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    public static boolean isValidNode(int row, int col) {
        return row >= 0 && row < grid.length // row의 유효성 확인 : 0 <= (행 좌표) < grid의 세로 길이(=행 크기)
                && col >= 0 && col < grid[0].length // col의 유효성 확인 : 0 <= (열 좌표) < grid의 가로 길이(=열 크기)
                && grid[row][col] == 1; // grid[row][col]이 다른 노드와 연결된 노드인지 확인
    }
}
