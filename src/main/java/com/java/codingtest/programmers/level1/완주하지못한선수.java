package com.java.codingtest.programmers.level1;

import java.util.*;

public class 완주하지못한선수 {

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42576
     * @param participant
     * @param completion
     * @return
     */
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참가자 이름을 key로 맵에 넣음 (value = 동명이인 count)
        for(String key : participant) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // map에서 완주자 이름이 있으면 value를 -1
        for(String key : completion) {
            map.put(key, map.get(key) - 1);
        }

        // map의 key마다
        // value가 0이면 (동명이인 포함 모두가) 완주
        // value가 0보다 크면 (동명이인 포함 value의 인원수만큼) 완주 못함
        String answer = "";

        for(String key : map.keySet()) {
            if(map.get(key) > 0) {
                answer = key;
            }
        }

        return answer;

    }
}
