package com.java.codingtest.programmers.level1;

import java.util.Arrays;

public class K번째수 {

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42748
     * @param array
     * @param commands
     * @return
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            // arr[0]번째 ~ arr[1]번째까지 자른 후 정렬
            int[] sorted = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(sorted);
            answer[i] = (sorted[commands[i][2]-1]);
        }

        return answer;
    }
}
