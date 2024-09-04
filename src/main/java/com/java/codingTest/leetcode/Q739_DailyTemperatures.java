package com.java.codingTest.leetcode;

import java.util.*;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that
 * answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Example)
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class Q739_DailyTemperatures {
    // 오늘 날씨보다 더 더운 날씨가 나올 때까지 스택에 데이터를 집어넣고,
    // 오늘보다 더운 날이 나오면 스택에 넣은 데이터를 뽑아주고 뽑히기까지의 일자를 계산
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length]; // 배열 길이=temperatures 길이, 모든 요소를 0으로 초기화
        Stack<Integer> stack = new Stack<>(); // temperatures의 인덱스를 저장하는 스택

        for (int i = 0; i < temperatures.length; i++) {
            // 지난 날보다 높은 온도가 등장했을 때
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop(); // 스택 맨 위의 데이터를 뽑음
                answer[temperatures[prevDay]] = i - prevDay;
            }
            stack.push(i);
        }

        return answer;
    }
}
