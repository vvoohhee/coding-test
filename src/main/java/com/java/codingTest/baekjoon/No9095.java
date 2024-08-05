package com.java.codingTest.baekjoon;

import java.util.Scanner;

public class No9095 {
    public static void main(String[] args) {
        /**
         * 정리한 규칙
         * n   : answer
         * n=1 : 1
         * n=2 : 2
         * n=3 : 4
         * n=4 : 7
         * n=5 : 13
         * n=6 : 24
         * ...
         *
         * 푸는 방법을 잘 모르겠어서 공책에 하나하나 적고 개수를 세어보았는데
         * n=4부터는 answer = answer(n-3) + answer(n-2) + answer(n-1) 과 같은 규칙을 찾아낼 수 있었다.
         */

        Scanner scanner = new Scanner(System.in);

        // t == testcase의 개수
        int t = scanner.nextInt();

        int[] answer = new int[12];
        answer[0] = 0;
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        for(int i=4; i<11; i++) answer[i] = answer[i-1] + answer[i-2] + answer[i-3];

        // testcase 개수만큼 반복문 돌리기
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            System.out.println(answer[n]);
        }
    }
}
