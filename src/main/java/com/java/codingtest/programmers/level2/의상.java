package com.java.codingtest.programmers.level2;

import java.util.*;

public class 의상 {

    /**
     * https://aram-su.tistory.com/22
     * @param clothes
     * @return
     */
    public int solution(String[][] clothes) {
        // 의상의 종류를 key로, 의상 종류별 개수를 value로
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] value : clothes) map.put(value[1], map.getOrDefault(value[1], 0) + 1);

        int combination = 1;

        // 해당 종류에서 아무것도 입지 않는 경우를 추가하여 +1 (투명옷이 있다고 생각해봐)
        for(int count : map.values()) {
            combination *= (count + 1);
        }

        // 발가벗은 경우는 없기때문에, 아무것도 입지 않는 경우(모두 투명옷 선택한 경우)를 빼준다.
        return --combination;
    }
}
