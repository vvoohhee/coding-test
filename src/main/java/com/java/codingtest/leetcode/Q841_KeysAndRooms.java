package com.java.codingtest.leetcode;

import java.util.*;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks,
 * and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 * <p>
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * <p>
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */
public class Q841_KeysAndRooms {
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);

        for (int i = 0; i < visited.length; i++) { // 하나라도 visited == false인 정점이 있으면 false 리턴
            if (!visited[i]) return false;
        }
        return true;
    }

    /**
     * DFS를 이용한 완전 탐색 풀이 :
     * 방문하지 않은 vertex에만 접근해서 접근 여부를 true로 변경 && 다음 vertex를 순회
     *
     * BFS, DFS 둘 다 테스트한 결과 DFS가 훨씬 빠르다..!
     */
    private void dfs(List<List<Integer>> rooms, int vertex) {
        if (!visited[vertex]) {
            visited[vertex] = true; // vertex의 방문 여부를 true로 변경
            for (int nextVertex : rooms.get(vertex)) { // rooms[vertex]에 있는 인접 노드를 dfs로 순회
                dfs(rooms, nextVertex);
            }
        }
    }

    /**
     * BFS를 이용한 완전 탐색 풀이 :
     * 방문하지 않은 vertex에만 접근해서, 접근 여부를 true로 변경 && 큐에 vertex를 넣고 다음 순차
     * 큐가 빌 때까지 계속 반복!
     */
    private void bfs(List<List<Integer>> rooms, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        while (!queue.isEmpty()) {
            List<Integer> nextNodes = rooms.get(queue.poll());
            for (int nextVertex : nextNodes) {
                if(!visited[nextVertex]) {
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
    }
}
