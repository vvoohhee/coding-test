import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCountMap = new HashMap<>(); // 장르 재생수 맵
        Map<String, ArrayList<int[]>> genreSongsMap = new HashMap<>(); // 장르에 속한 고유번호 리스트 맵
        
        // map에 적절한 값 추가 -> 시간복잡도 O(N)
        for(int i=0; i<plays.length; i++) { 
            genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i], 0) + plays[i]);
            genreSongsMap.putIfAbsent(genres[i], new ArrayList<>());
            genreSongsMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 장르별 재생수 map 정렬 -> 시간복잡도 O(nlogN)
        Stream<Map.Entry<String, Integer>> sortedGenre = genreCountMap.entrySet()
            .stream()
            .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        // 정답 리스트에 값 채우기
        ArrayList<Integer> answer = new ArrayList<>();
        sortedGenre.forEach(entry -> {
            Stream<int[]> top2 = genreSongsMap.get(entry.getKey()).stream()
                .sorted((a, b) -> {
                    if (b[1] != a[1]) return Integer.compare(b[1], a[1]); // 재생수 기준 내림차순
                    else return Integer.compare(a[0], b[0]); // 고유번호 기준 오름차순
                })
                .limit(2);

            top2.forEach(song -> answer.add(song[0]));
        });
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}