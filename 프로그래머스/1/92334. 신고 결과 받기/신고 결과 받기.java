import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 아이디별 인덱스를 저장
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) idIndexMap.put(id_list[i], i);

        // 유저의 신고 목록과 신고 횟수를 저장하는 맵
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        
        // report 배열을 돌면서 신고 목록과 신고 횟수를 갱신
        for (String str : report) {
            String[] arr = str.split(" ");
            String reporter = arr[0];
            String reported = arr[1];
            
            reportMap.putIfAbsent(reporter, new HashSet<>());
            
            // 중복 신고 방지
            if (reportMap.get(reporter).add(reported)) { 
                reportCountMap.put(reported, reportCountMap.getOrDefault(reported, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        // 정지 대상에 대해 메일 개수++
        for (String reported : reportCountMap.keySet()) {
            if (reportCountMap.get(reported) >= k) {
                for (String reporter : reportMap.keySet()) {
                    if (reportMap.get(reporter).contains(reported)) {
                        answer[idIndexMap.get(reporter)]++;
                    }
                }
            }
        }
        
        return answer;
    }
}