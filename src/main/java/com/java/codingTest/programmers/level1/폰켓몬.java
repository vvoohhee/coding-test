package com.java.codingTest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 폰켓몬 {

    /**
     * 문제 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
     * @param nums 폰켓몬의 종류 번호가 담긴 1차원 배열
     * @return 가장 많은 종류 번호의 개수
     */

    public int solution(int[] nums) {
        int n = nums.length / 2;

        List<Integer> pokemonList = new ArrayList<>();
        for (int num : nums) {
            if (pokemonList.contains(num)) {
                continue;
            } else {
                pokemonList.add(num);
            }
        }

        int answer = 0;

        if (pokemonList.size() < n) {
            answer = pokemonList.size();
        } else {
            answer = n;
        }

        return answer;
    }
}
