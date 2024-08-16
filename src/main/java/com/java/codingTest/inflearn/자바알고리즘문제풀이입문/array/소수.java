package com.java.codingTest.inflearn.자바알고리즘문제풀이입문.array;

import java.util.*;

public class 소수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = countPrimeNumbers(n);
    }

    /**
     * 에라토스테네스의 체 방법을 이용해서
     * 1부터 n까지 소수의 개수를 구하는 메서드 ( 2 <= n <= 200,000 )
     * <p>
     * 에라토스테네스의 체 :
     * 1) 2부터 n까지의 모든 수를 나열
     * 2) 가장 작은 소수인 2부터 시작하여, 가장 작은 소수를 찾아 그 수의 배수를 모두 제거
     * 3) 이 과정을 반복하여 제거되지 않은 수들은 모두 소수
     *
     * @param n
     * @return int
     */
    public static int countPrimeNumbers(int n) {
        boolean[] prime = new boolean[n + 1]; // 인덱스 = 자연수 i로 계산하기 위함

        // 모든 숫자를 소수로 초기화 (prime = true)
        for (int i = 2; i <= n; i++) prime[i] = true;

        // 에라토스테네스의 체 알고리즘 구현
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int multiple = i * i; multiple <= n; multiple += i)
                    prime[multiple] = false; // i의 배수에 대해 false로 변경
            }
        }

        // 소수 개수를 계산
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) answer++;
        }

        return answer;
    }
}
