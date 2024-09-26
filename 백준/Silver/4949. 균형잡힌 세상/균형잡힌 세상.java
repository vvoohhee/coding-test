import java.util.*;

public class Main {
    public static final HashMap<Character, Character> pair = new HashMap<>();

    public static void main(String[] args) {
        pair.put('(', ')');
        pair.put('[', ']');

        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) break;
            System.out.println(isBalanced(s));
        }
    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (pair.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (pair.containsValue(c)) {
                if (stack.isEmpty() || pair.get(stack.pop()) != c) return "no";
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}