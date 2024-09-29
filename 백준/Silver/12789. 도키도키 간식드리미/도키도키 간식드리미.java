import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> line = new LinkedList<>();
        for (int i = 0; i < n; i++) line.addLast(sc.nextInt());

        System.out.println(clearLine(line));
    }

    public static String clearLine(Deque<Integer> line) {
        Stack<Integer> leftLine = new Stack<>();
        int turn = 1;
        while (!line.isEmpty()) {
            if (line.peekFirst() == turn) {
                line.pollFirst();
                turn++;
            } else if (!leftLine.isEmpty() && leftLine.peek() == turn) {
                leftLine.pop();
                turn++;
            } else {
                leftLine.push(line.pollFirst());
            }
        }

        while (!leftLine.isEmpty()) {
            if (leftLine.pop() == turn) turn++;
            else return "Sad";
        }

        return "Nice";
    }
}