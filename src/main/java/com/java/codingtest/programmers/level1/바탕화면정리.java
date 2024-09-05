package com.java.codingtest.programmers.level1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 *
 * 제약조건 :
 * 1 ≤ wallpaper의 길이 ≤ 50
 * 1 ≤ wallpaper[i]의 길이 ≤ 50
 * wallpaper의 모든 원소의 길이는 동일합니다.
 * wallpaper[i][j]는 바탕화면에서 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
 * wallpaper[i][j]는 "#" 또는 "."의 값만 가집니다.
 * 바탕화면에는 적어도 하나의 파일이 있습니다.
 * 드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 lux < rdx, luy < rdy를 만족해야 합니다.
 *
 * 입출력 예 :
 * 입력                           출력
 * [".#...", "..#..", "...#."]	[0, 1, 3, 4]
 */
public class 바탕화면정리 {
    public int[] solution1(String[] wallpaper) {
        // (lux, luy) = 가장 위/왼쪽에 있는 좌표
        // (rdx, rdy) = 가장 아래/오른쪽에 있는 좌표
        // String배열의 index  = lux/rdx를 결정
        // String배열의 #value = luy, rdy를 결정

        int lux = 50, luy = 50, rdx = 0, rdy = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(lux > i ) lux = i;
                    if(luy > j ) luy = j;
                    if(rdx < i) rdx = i;
                    if(rdy < j) rdy = j;
                }
            }
        }

        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }

    public int[] solution2(String[] wallpaper) {
        // (lux, luy) = 가장 위/왼쪽에 있는 좌표
        // (rdx, rdy) = 가장 아래/오른쪽에 있는 좌표
        // String배열의 index  = lux/rdx를 결정
        // String배열의 #value = luy, rdy를 결정

        int lux = 50, luy = 50, rdx = 0, rdy = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}
