package com.java.codingtest.programmers.level1;

import java.util.*;

public class 같은숫자는싫어 {

    /**
     * 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/12906
     * @param arr 0부터 9까지로 이루어진 숫자 배열
     * @return 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들의 배열
     */
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(i == 0) {
                list.add(arr[i]);
            } else {
                if(arr[i] == arr[i-1]) {
                    continue;
                } else {
                    list.add(arr[i]);
                }
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
