package com.java.codingTest.inflearn.코딩테스트올인원;

public class TwoPointer {
    /**
     * Tow Pointer 기법이란?
     * -------------------
     * Two Pointer 기법에서는 보통 두 개의 포인터가 사용된다.
     * 이 포인터들은 보통 배열이나 리스트의 시작/끝에서 출발하여 서로 다른 방향으로 이동한다.
     * 이 기법은 문제의 요구 사항헤 따라 두 포인터를 사용하여 배열을 효율적으로 탐색하고, 특정 조건을 만족하는 해답을 찾기 위해 사용된다.
     * -------------------
     * Two Pointer가 유용하게 사용되는 케이스는 다음과 같다.
     * 1) 두 숫자의 합이 특정 숫자가 되어야 하는 문제
     * 2) 배열에서 구간 합이 특정 숫자와 일치해야 하는 문제
     * 3) 중복을 허용하지 않는 부분 문자열을 찾는 문제
     * <p>
     * 완전 탐색은 이중 for문을 사용하게 되어 O(n^2) 시간복잡도가 되지만, Two pointer로는 O(n logn) + O(n) 시간복잡도로 해결 가능하다.
     */

    public boolean solution(int[] numbers, int target) {
        int leftPointer = 0, rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        return false;
    }
}
