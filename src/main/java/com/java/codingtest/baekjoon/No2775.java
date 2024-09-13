package com.java.codingtest.baekjoon;

import java.util.Scanner;

/**
 * 문제 설명
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
 * <p>
 * 이 아파트에 거주를 하려면 조건이 있는데,
 * “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다”
 * 는 계약 조항을 꼭 지키고 들어와야 한다.
 * <p>
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
 * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 * <p>
 * 제약 조건
 * 1 ≤ k, n ≤ 14 (최대 14층 14호)
 */
public class No2775 {
    public static void main(String[] args) {
        // k, n의 제약이 14니까.. 최대 14층 14호짜리 아파트에 대해서 값을 채워보면?
        int[][] dp = new int[15][15]; // 층은 0층부터, 호는 1호부터 시작하므로

        // dp[0]에 대해 주민 수를 채워넣기
        for (int i = 1; i < 15; i++) dp[0][i] = i;

        // 1층 이상의 주민 수를 채워넣기 (단, dp를 이용해서 중복계산 하지 않기!)
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            System.out.println(dp[k][n]);
        }
    }
}
