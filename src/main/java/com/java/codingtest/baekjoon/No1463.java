package com.java.codingtest.baekjoon;

import java.util.*;

/**
 * 문제 설명
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 *
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 제약 조건
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 */
public class No1463 {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        dp = new Integer[n + 1]; // n을 1로 만들기 위한 연산 횟수 배열
        dp[1] = 0; // n=1 -> 필요한 연산 횟수 = 0

        // 작은 수부터 dp배열에 채워나가기
        for (int i = 2; i <= n; i++) {
            // i를 1로 만드는 방법 = i-1을 1로 만드는 방법 + 1 (1을 한 번 더 빼주면 되니까)
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                // i를 1로 만드는 방법 = i/2를 1로 만드는 방법 + 1 (i/2에 2 곱하면 i가 되니까)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                // i를 1로 만드는 방법 = i/3를 1로 만드는 방법 + 1 (i/3에 3 곱하면 i가 되니까)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
