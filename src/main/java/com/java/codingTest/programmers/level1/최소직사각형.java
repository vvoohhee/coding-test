package com.java.codingTest.programmers.level1;

import java.lang.Math;

public class 최소직사각형 {

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/86491
     * @param sizes
     * @return
     */
    public int solution(int[][] sizes) {
        // 1. 가로 길이가 세로 길이보다 길지 않도록 정렬한다.
        // 2. 가로 길이의 최댓값, 세로 길이의 최댓값을 찾는다.
        // 3. 지갑의 크기를 리턴한다. (가로*세로)

        int maxLength = 0; // 가로
        int maxWidth = 0; // 세로

        /*
        처음 풀었던 방법 :
        for(int[] card : sizes) {
            if(card[0] < card[1]) { // 가로 길이가 세로 길이보다 작으면
                // card[0](가로)와 card[1](세로) 값을 서로 바꾼다.
                int tmp = card[0];
                card[0] = card[1];
                card[1] = tmp;
            }

            if(maxLength < card[0]) maxLength = card[0]; // 가로 길이 최댓값 찾기
            if(maxWidth < card[1]) maxWidth = card[1]; // 세로 길이 최댓값 찾기
        }
        */

        // 다른 사람의 풀이 참고
        // : Math 클래스의 max, min 메서드를 이용하는 방법
        for(int[] card : sizes) {
            maxLength = Math.max(maxLength, Math.max(card[0], card[1]));
            maxWidth = Math.max(maxWidth, Math.min(card[0], card[1]));
        }

        return maxLength * maxWidth; // 가로 길이 최댓값 * 세로 길이 최댓값
    }
}
