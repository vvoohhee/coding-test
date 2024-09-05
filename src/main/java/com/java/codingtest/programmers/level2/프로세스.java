package com.java.codingtest.programmers.level2;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i < priorities.length; i++) queue.add(new int[]{priorities[i], i});

        int answer = 0; // location 위치의 순번을 구하기 위한 변수
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean isHighest = true;

            for(int[] q : queue) {
                if(current[0] < q[0]) {
                    queue.add(current); // current를 큐의 맨 뒤로 보냄
                    isHighest = false;
                    break; // for문을 빠져나가 큐의 다음 요소에 대해 반복하기 위함
                }
            }

            if(isHighest) {
                answer++; // 반복문을 다 돌았는데, current의 우선순위보다 높은 요소가 없는 경우 = 실행
                if(current[1] == location) return answer;
            }
        }

        return answer;
    }
}
