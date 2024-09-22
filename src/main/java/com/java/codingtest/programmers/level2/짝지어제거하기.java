package com.java.codingtest.programmers.level2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (!stack.isEmpty() && current == stack.peek()) stack.pop();
            else stack.push(current);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
