package com.java.codingTest.programmers.level2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요
 *
 * 제약 조건 :
 * numbers의 길이는 1 이상 100,000 이하입니다. (10^5)
 * numbers의 원소는 0 이상 1,000 이하입니다. (10^3)
 *
 */
public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(answer, (a, b) -> (b + a).compareTo(a + b));

        // 숫자가 모두 0인 경우 "0" 리턴
        return answer[0].equals("0") ? "0" : String.join("", answer);
    }
}
