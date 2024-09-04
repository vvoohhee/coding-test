package com.java.codingTest.leetcode;

import java.util.LinkedList;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 * <p>
 * BrowserHistory는 뒤로가기, 현재URL, 앞으로가기가 있어야 함
 * -> LinkedList로 구현 가능
 */
class BrowserHistory {
    private LinkedList<String> history = new LinkedList<>();
    int current = 0; // 현재 요청한 페이지의 인덱스

    // Initializes the object with the homepage of the browser
    public BrowserHistory(String homepage) {
        // 첫 번쨰 요소이므로 current는 0으로 유지
        history.add(homepage);
    }

    //void visit(string url) Visits url from the current page. It clears up all the forward history.
    public void visit(String url) {
        // current 인덱스를 1 더하고 linkedList에 URL 추가
        current++;
        history.add(url);

        // forward history 삭제
        while (current < history.size() - 1) {
            history.removeLast();
        }
    }

    // Move steps back in history.
    // If you can only return x steps in the history and steps > x, you will return only x steps.
    // Return the current url after moving back in history at most steps.
    public String back(int steps) {
        // current < steps : current=0, 0번 인덱스의 url 리턴
        if (current < steps) {
            current = 0;
            return history.getFirst();
        }
        current -= steps;
        return history.get(current);
    }

    // Move steps forward in history.
    // If you can only forward x steps in the history and steps > x, you will forward only x steps.
    // Return the current url after forwarding in history at most steps.
    public String forward(int steps) {
        // history.size() < current + steps : current=마지막인덱스, 마지막 인덱스의 url 리턴
        if(history.size() <= current + steps) {
            current = history.size() - 1;
            return history.getLast();
        }
        current += steps;
        return history.get(current);
    }
}
