package com.java.codingtest.leetcode;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * 1 <= n <= 45
 */
public class Q70_ClimbingStairs {
    /*
    base case
        - n = 1 --> ans = 1
        - n = 2 --> ans = 2

    brainstorming
        <n번째 계단으로 가는 법>
        - 3번째 계단으로 가는 법 = 2층에서 1층만큼 더 올라오기 + 1층에서 2층만큼 더 올라오기 = f(2) + f(1)
        - 4번째 계단으로 가는 법 = 3층에서 1층만큼 더 올라오기 + 2층에서 2층만큼 더 올라오기 = f(3) + f(2)
        - 5번째 계단으로 가는 법 = 4층에서 1층만큼 더 올라오기 + 3층에서 2층만큼 더 올라오기 = f(4) + f(3)
        => 따라서 n번째 계단을 가는 법은 다음과 같다 : f(n) = f(n-1) + f(n-2)

        <개선하는 방법>
        - f(n) = f(n-1) + f(n-2) 을 계속 반복하므로 f(n)에 대한 연산이 반복되는 경우가 많을 것이다.
        => 따라서 DP를 활용해 이미 구해진 n에 대한 해를 메모리에 저장하도록 한다
        => dp[n] = f(n)
     */

    private static int[] dp;

    public int climbStairs(int n) {
        // dp 배열 선언 및 초기화, base case 지정
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // return climb1(n);
        return climb2(n);
    }

    /**
     * Top-down 방식의 DP로 구현
     */
    private int climb1(int n) {
        // memorization 되었다면 메모리의 dp[n] 리턴
        if (dp[n] != 0) return dp[n];

        // memorization 안되었으면 메모리의 dp[n]에 해를 저장, 리턴
        dp[n] = climb1(n - 1) + climb1(n - 2);
        return dp[n];
    }

    /**
     * Bottom-up 방식의 DP로 구현
     */
    private int climb2(int n) {
        // bottom-up 방식으로 DP 구현 (dp[3]~dp[n]까지 배열을 채운다.)
        for (int i = 3; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }


}
