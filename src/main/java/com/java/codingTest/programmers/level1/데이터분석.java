package com.java.codingTest.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 데이터분석 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/250121
     * @param data
     * @param ext
     * @param val_ext
     * @param sort_by
     * @return
     */
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> extMap = new HashMap<>();
        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);

        int extIdx = extMap.get(ext);
        int sortIdx = extMap.get(sort_by);

        List<int[]> result =
                Arrays.stream(data).filter(value -> value[extIdx] < val_ext).collect(Collectors.toList());

        result.sort((a, b) -> a[sortIdx] - b[sortIdx]);

        int[][] answer = new int[result.size()][data[0].length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
