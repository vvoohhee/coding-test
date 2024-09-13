package com.java.codingtest.programmers.level2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 *
 * 문제 설명
 * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
 *
 * x에 n을 더합니다
 * x에 2를 곱합니다.
 * x에 3을 곱합니다.
 * 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
 * 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 *
 * 제한 사항
 * 1 ≤ x ≤ y ≤ 1,000,000
 * 1 ≤ n < y
 */
public class 숫자변환하기 {
    /**
     * 최소 횟수를 찾는 거니까 bfs를 이용하면 좋지 않을까..? 라는 생각을 함
     * 그리고 숫자 하나에 대해서 *3, *2, +n 계산이 필요하니까 하나의 노드를 방문할 때마다 *3, *2, +n을 각각 해주어야 하고
     * 그 연산이 모두 끝나야 count를 늘려야 한다!
     * 하지만 계산 결과가 y보다 작거나 같은 경우에만 큐에 넣어줘야 한다. (그러지 않으면 무한연산하게 되니까)
     */
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        boolean[] visited = new boolean[y + 1];
        visited[x] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                if (node == y) return count;

                int mul2 = node * 2;
                int mul3 = node * 3;
                int plusN = node + n;

                if (mul2 <= y && !visited[mul2]) {
                    queue.offer(mul2);
                    visited[mul2] = true;
                }

                if (mul3 <= y && !visited[mul3]) {
                    queue.offer(mul3);
                    visited[mul3] = true;
                }

                if (plusN <= y && !visited[plusN]) {
                    queue.offer(plusN);
                    visited[plusN] = true;
                }
            }

            count++;
        }

        return -1;
    }
}
