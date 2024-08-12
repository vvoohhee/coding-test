package com.java.codingTest.inflearn.자바알고리즘문제풀이입문.array;

import java.util.Scanner;

public class 큰수출력하기 {
    public static void main(String[] args) {

        /**
         * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요. (첫 번째 수는 무조건 출력한다)
         * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
         **/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) array[i] = sc.nextInt();

        /**
         * String에 += " " + array[i] 을 사용하지 않고 StringBuilder 객체 생성 후 append() 메서드 사용하는 이유 :
         *
         * String은 불변 객체이기 때문에 객체 생성 이후 값이 변경되지 않는다.
         * String에 += 연산자를 사용하면, 값이 변하는 것처럼 보이지만 새로운 String이 메모리에 생성된다.
         *
         * 반면 StringBuilder 객체는 가변객체다.
         * 즉, 새로운 객체 생성 없이 기존에 생성된 StringBuilder 객체 내부의 문자열을 수정할 수 있다.
         *
         * 따라서 문자열이 자주 변경되거나 연결(append)될 때에는 String보다 StringBuilder가 사용하기 적합하다.
         * (하지만 StringBuilder는 동기화를 지원하지 않기때문에 멀티 스레드 환경에서는 일관성을 보장하지 않는다.
         *
         * 멀티 스레드 환경에서 자주 변경되는 String을 다루어야 하는 경우에는, StringBuffer를 사용하기를 권장한다.
         */
        StringBuilder answer = new StringBuilder();

        answer.append(array[0]); // 첫 번째 수는 무조건 출력하게 만듦
        for (int i = 1; i < n; i++) {
            if(array[i] > array[i-1]) answer.append(" ").append(array[i]); // answer += " {array[i]}"
        }

        System.out.println(answer);
    }
}