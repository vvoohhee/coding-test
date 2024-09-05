package com.java.codingtest.programmers.level1;

import java.util.Arrays;

public class 체육복 {

    /**
     * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42862
     * @param n 전체 학생의 수
     * @param lost 체육복을 도둑맞은 학생의 수
     * @param reserve 여벌의 체육복을 가지고 있는 학생의 수
     * @return 체육수업을 들을 수 있는 최대 인원
     */
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);
        Arrays.sort(lost);

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

}
