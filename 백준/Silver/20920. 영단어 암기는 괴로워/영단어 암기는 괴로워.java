import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= min) map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> filteredWords = new ArrayList<>(map.keySet());

        filteredWords.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });

        StringBuffer result = new StringBuffer();
        for (String word : filteredWords) {
            result.append(word).append("\n");
        }

        System.out.print(result.toString());
    }
}