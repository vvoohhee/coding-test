package com.java.codingtest.programmers.level3;

import java.util.*;

public class 표편집 {
    static final char deleted = 'X';
    static final char notDeleted = 'O';

    public String solution(int n, int k, String[] cmd) {
        int rows = n;
        Stack<Integer> deletedRows = new Stack<>();
        char[] answer = new char[n];

        // 1. 덱에 행번호, answer 배열 값 초기화
        Arrays.fill(answer, notDeleted);

        // 2. 현재 위치의 행 번호 k를 시작으로 cmd 실행
        for (String command : cmd) {
            if (command.startsWith("U")) {
                int move = Integer.parseInt(command.split(" ")[1]);
                k -= move;
                if (k < 0) k = 0;
            } else if (command.startsWith("D")) {
                int move = Integer.parseInt(command.split(" ")[1]);
                k += move;
                if (k >= rows) k = rows - 1;
            } else if (command.equals("C")) {
                // 스택에 삭제된 행 번호 추가
                deletedRows.push(k);
                // 현재 행 삭제 처리
                answer[k] = deleted;
                rows--;
                if (k == rows) k = rows - 1;
                // 아래 칸으로 이동 (현재 행이 가장 마지막이면 윗 칸으로 이동)
            } else if (command.equals("Z") && !deletedRows.isEmpty()) {
                int zRow = deletedRows.pop();
                answer[zRow] = notDeleted;
                rows++;
                if (zRow <= k) k = k + 1;
            }
        }

        return new String(answer);
    }
}