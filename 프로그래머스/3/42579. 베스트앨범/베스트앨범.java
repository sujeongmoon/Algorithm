import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genreFrequencyMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> songFrequencyMap = new HashMap<>();
        
        // 장르별로 얼마나 플레이됐는지 누적 빈도 map 생성
        for (int i = 0; i < genres.length; i++) {
            genreFrequencyMap.put(genres[i], genreFrequencyMap.getOrDefault(genres[i], 0) + plays[i]);
            
            // 해당 장르가 songFrequencyMap에 안 들어가있다면 put을 새로 넣고(index와 plays[i]를 key, value로 넣어줌.), 이미 있다면 value인 ArrayList에 plays를 add
            if (!songFrequencyMap.containsKey(genres[i])) {
                songFrequencyMap.put(genres[i], new ArrayList<>());
            } 
            songFrequencyMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // genreFrequencyMap, value값 기준으로 내림차순 sort
        Stream<Map.Entry<String, Integer>> sortGenre = genreFrequencyMap.entrySet()
            .stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortGenre.forEach(entry -> {
            Stream<int[]> sortSong = songFrequencyMap.get(entry.getKey())
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);
            sortSong.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}