import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int changeCount = 0;

        for (int i = 0; i < record.length; i++) {
            String[] command = record[i].split(" ");

            if (command[0].equals("Enter")) {
                map.put(command[1], command[2]);
            } else if (command[0].equals("Change")) {
                changeCount++;
                map.put(command[1], command[2]);
            }
        }

        String[] answer = new String[record.length - changeCount];
        int index = 0;

        for (int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            String nickname = map.get(info[1]);

            if (info[0].equals("Enter")) {
                answer[index++] = nickname + "님이 들어왔습니다.";
            } else if (info[0].equals("Leave")) {
                answer[index++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}