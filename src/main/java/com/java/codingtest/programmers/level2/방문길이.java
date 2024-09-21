package com.java.codingtest.programmers.level2;

import java.util.*;


public class 방문길이 {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();

        Map<Character, int[]> move = new HashMap<>();
        move.put('L', new int[]{-1, 0});
        move.put('R', new int[]{1, 0});
        move.put('U', new int[]{0, 1});
        move.put('D', new int[]{0, -1});

        int x = 0, y = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int[] direction = move.get(dirs.charAt(i));
            int nextX = x + direction[0], nextY = y + direction[1];

            if (validate(nextX, nextY)) {
                // 중복값은 Set에서 걸러주므로 바로 추가
                visited.add(x + "," + y + ">" + nextX + "," + nextY);
                visited.add(nextX + "," + nextY + ">" + x + "," + y);

                x = nextX;
                y = nextY;
            }
        }

        // 왕복 길이니까 /2
        return visited.size() / 2;
    }

    private boolean validate(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
}
