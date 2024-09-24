package com.java.codingtest.programmers.level2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            // 이전 주식가격 중 prices[i]보다 작은 것이 있는지 확인, 있으면 가격이 떨어지지 않은 기간을 계산
            // while문을 쓰는 이유 : prices[i] 시점에 최초로 떨어진 주식 가격이 둘 이상일 수 있기 때문
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.peek();
                answer[index] = i - index;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = length - 1 - index;
        }

        return answer;
    }
}
