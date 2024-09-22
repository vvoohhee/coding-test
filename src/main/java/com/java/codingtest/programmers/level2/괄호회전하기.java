package com.java.codingtest.programmers.level2;


import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * <p>
 * ()[{}]
 */
public class 괄호회전하기 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');

        int answer = 0;

        if (s.length() % 2 == 1) return answer;

        Deque<Character> stringDeque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) stringDeque.add(s.charAt(i));

        for (int i = 0; i < s.length(); i++) {
            // 2. 회전시킨 문자열이 알맞은 괄호 문자열인지 확인 = 돌아가면서 괄호 짝을 확인 -> O(n)
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (Character c : stringDeque) {
                if (pair.containsKey(c)) { // 여는 괄호
                    stack.push(c); // 스택에 push
                } else { // 닫는 괄호
                    if (!stack.isEmpty() && pair.get(stack.peek()) == c) { // 스택의 맨 위 요소와 닫는 괄호의 짝 확인
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            // 3. if 올바른 문자열 => answer++;
            if (flag && stack.isEmpty()) answer++;

            // 4. 문자열 회전
            stringDeque.add(stringDeque.pollFirst());
        }

        return answer;
    }
}
