package com.java.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * -> 인형 스택을 만들지 않고 moves가 board 배열을 바로 접근하도로 하면
 *    시간 복잡도를 O(n^2)에서 O(n)까지 줄일 수 있을 것 같다...
 */
public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 1. 길이가 board.length인 스택 리스트 만들기  ==> O(n^2)
        ArrayList<Stack<Integer>> boardList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = board[0].length - 1; j >= 0; j--) { // 스택이므로 밑부터 채우기
                // 0은 빈칸이므로 0은 채우지 않기
                if (board[j][i] != 0) stack.push(board[j][i]);
            }
            boardList.add(stack);
        }

        // 2. moves를 반복하며 인형을 뽑아 뽑은 인형 스택에 push  ==> O(n)
        // 2-1. 만약 push하려는 인형과 뽑은 인형 스택의 top이 같은 인형이면 폭발 == answer을 2 증가
        Stack<Integer> stack = new Stack<>();
        for (int i : moves) {
            int selected = boardList.get(i - 1).isEmpty() ? 0 : boardList.get(i - 1).pop();
            if (selected == 0) continue; // 뽑은 인형이 0번이라면 아무일도 일어나지 않음
            if (stack.isEmpty()) {
                stack.push(selected);
                continue;
            }

            int top = stack.peek();
            if (top == selected) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(selected);
            }
        }

        return answer;
    }
}
