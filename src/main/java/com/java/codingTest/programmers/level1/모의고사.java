package com.java.codingTest.programmers.level1;

public class 모의고사 {

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42840
     * @param answers
     * @return
     */
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int scoreA = 0, scoreB = 0, scoreC = 0;

        for(int i=0; i<answers.length; i++) {
            if(a[i % a.length] == answers[i]) scoreA++;
            if(b[i % b.length] == answers[i]) scoreB++;
            if(c[i % c.length] == answers[i]) scoreC++;
        }

        int max = Math.max(scoreA, Math.max(scoreB, scoreC));

        int count = 0;
        if(scoreA == max) count++;
        if(scoreB == max) count++;
        if(scoreC == max) count++;

        int[] answer = new int[count];

        int index = 0;
        if(scoreA == max) answer[index++] = 1;
        if(scoreB == max) answer[index++] = 2;
        if(scoreC == max) answer[index++] = 3;

        return answer;

    }
}
