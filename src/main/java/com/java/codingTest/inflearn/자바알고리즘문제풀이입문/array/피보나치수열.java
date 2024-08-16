package com.java.codingTest.inflearn.자바알고리즘문제풀이입문.array;

import java.util.*;

public class 피보나치수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i : getFibonacci(n)) System.out.println(i);
    }

    /**
     * n개만큼의 피보나치 수열 구하는 메서드 (n <= 3 <= 45)
     * 피보나치 수열 : 앞의 두 수를 더하면 다음 숫자가 되는 수열
     * 1 1 2 3 5 8 13 ...
     */
    public static int[] getFibonacci(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        return fibonacci;
    }
}
