package com.java.codingTest.programmers.level2;

import java.util.*;

public class 전화번호목록 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42577
     * @param phone_book 전화번호부
     * @return
     */
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}
