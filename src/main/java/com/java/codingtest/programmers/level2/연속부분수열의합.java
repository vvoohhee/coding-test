package com.java.codingtest.programmers.level2;

public class 연속부분수열의합 {
    /**
     * 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
     * <p>
     * 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
     * 부분 수열의 합은 k입니다. 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
     * 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
     * 수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때,
     * 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요.
     * 이때 수열의 인덱스는 0부터 시작합니다.
     * <p>
     * 입력값 〉	[1, 2, 3, 4, 5], 7
     * 기댓값 〉	[2, 3]
     */
    public int[] solution(int[] sequence, int k) {
        int start = 0;       // 윈도우의 시작 포인터
        int sum = 0;         // 현재 윈도우의 합
        int minLength = Integer.MAX_VALUE; // 최소 윈도우 길이
        int bestStart = -1;  // 최적의 윈도우 시작 인덱스
        int bestEnd = -1;    // 최적의 윈도우 끝 인덱스

        for (int end = 0; end < sequence.length; end++) { // end를 1씩 늘려 윈도우 오른쪽 끝을 확장
            sum += sequence[end];

            // 윈도우의 합이 목표 값 k를 초과하면 윈도우의 왼쪽 끝 조정 (오른쪽 끝이 end인 경우 sum=k인 값이 있는지 찾기 위함임)
            while (sum > k && start <= end) sum -= sequence[start++];

            // 윈도우의 합이 k일 때, 윈도우의 합이 최적의 경우면 bestStart, bestEnd를 변경
            if (sum == k) {
                if ((end - start + 1) < minLength) {
                    minLength = end - start + 1;
                    bestStart = start;
                    bestEnd = end;
                }
            }
        }

        return new int[] { bestStart, bestEnd };
    }
}
