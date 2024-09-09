package com.java.codingtest.leetcode;

import java.util.*;

/**
 * Given an n x n binary matrix grid,
 * return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
public class Q1091_ShortestPathInBinaryMatrix {
    // 탐색 방향 = 북, 동북, 동, 남동, 남, 남서, 서, 북서
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int rowLength;
    static int colLength;

    public int shortestPathBinaryMatrix(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        int shortestPath = -1;

        if (grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) return shortestPath;
        boolean[][] visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1}); // {row, col, 방문경로개수}

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int row = curNode[0], col = curNode[1], path = curNode[2];

            if (row == rowLength - 1 && col == colLength - 1) {
                shortestPath = path;
                break; // bottom-right cell에 도착했으면 리턴
            }

            for (int i = 0; i < 8; i++) { // 8-directionally connected
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                // nextRow, nextCol 유효한 인덱스인지 + 아직 방문하지 않은 노드인지 확인
                if (isValid(nextRow, nextCol) && grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, path + 1});
                }
            }
        }
        return shortestPath;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rowLength // row 유효성 검사
                && col >= 0 && col < colLength;
    }
};
