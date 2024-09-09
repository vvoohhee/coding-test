package com.java.codingtest.leetcode;

import java.util.Queue;
import java.util.LinkedList;

class Q200_NumbersOfIsland {
    boolean isInRange(int r, int c, int rowLength, int colLength){
        return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength);
    }

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean visited[][]  = new boolean[rowLength][colLength];


        for( int i = 0; i < rowLength; i++ ) {
            for ( int j = 0; j < colLength; j++ ){
                if ((grid[i][j] == '1') &&  (!visited[i][j])){
                    bfs(i,j, grid, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public void bfs(int r, int c, char[][] grid, boolean[][] visited){
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Pair<Integer, Integer> cur = q.poll();
            int curRow = cur.getLeft();
            int curCol = cur.getRight();

            for (int[] d : dir){
                int nextRow = curRow + d[0];
                int nextCol = curCol + d[1];

                if (isInRange(nextRow, nextCol, rowLength, colLength)){
                    if (grid[nextRow][nextCol] == '1' && !(visited[nextRow][nextCol])){
                        visited[nextRow][nextCol] = true;
                        q.offer(new Pair<>(nextRow, nextCol));
                    }
                }
            }
        }
    }

    class Pair<L, R> {
        L left;
        R right;

        private Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return this.left;
        }

        public R getRight() {
            return this.right;
        }
    }
}