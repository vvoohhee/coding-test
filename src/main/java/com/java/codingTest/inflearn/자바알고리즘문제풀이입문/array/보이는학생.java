package com.java.codingTest.inflearn.자바알고리즘문제풀이입문.array;

import java.util.*;

public class 보이는학생 {

    /**
     * <b>설명</b>
     * 선생님이 N명의 학생을 일렬로 세웠습니다.
     * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
     * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     *
     * <b>입력</b>
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     *
     * <b>출력</b>
     * 선생님이 볼 수 있는 최대학생수를 출력한다.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        // 풀이 1 )
        int[] heights = new int[count];
        for (int i = 0; i < count; i++) heights[i] = scanner.nextInt();

        System.out.print(visibleCount(heights));
    }

    private static int visibleCount(int[] heights) {
        int visibleCount = 1;
        if (heights[0] >= heights[1]) return visibleCount;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < heights[i + 1]) visibleCount++;
            else return visibleCount;
        }

        return visibleCount;
    }
}
