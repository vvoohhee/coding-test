package com.java.codingTest.programmers.level2;

import java.util.Stack;

public class 올바른괄호 {
    /**
     * 스택 문제 풀이
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때,
     * 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 해주세요.
     * @param s
     * @return
     */
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty(); // 괄호가 바르게 짝지어졌다면 stack이 비워졌을 것
    }
}
