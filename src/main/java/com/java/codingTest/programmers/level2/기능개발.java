package com.java.codingTest.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++)
            queue.add((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));

        int poll = queue.poll(); // 큐의 첫 번째 요소 (== 첫 기능)
        int count = 1; // 같은 날에 배포될 기능 개수
        while (!queue.isEmpty()) {
            if (poll >= queue.peek()) { // poll = 앞 기능 소요일자, peek = 바로 뒷 기능 소요일자
                count++; // (앞 기능 소요일자) >= (바로 뒷 기능 소요일자) 이면 count를 1 증가
                queue.poll(); // 다음 기능 배포일자도 계산해야하므로 peek()으로 뽑아낸 (뒤 기능 배포일자)를 큐에서 삭제하고 계속 진행
            } else {
                answer.add(count); // (앞 기능 소요일자) < (바로 뒷 기능 소요일자) 이면 같은 날에 배포될 기능 개수를 확정 가능 -> list에 추가
                poll = queue.poll(); // 이번 기능부터 count를 다시 계산해야 하므로 poll=(이번 기능 소요일자), count=1 로 초기화
                count = 1;
            }
        }

        // 가장 마지막까지 계산되다가 queue가 비게 되면, 마지막 배포의 기능 개수는 anser에 add()되지 않으므로 추가시켜줌
        answer.add(count);

        return answer
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
