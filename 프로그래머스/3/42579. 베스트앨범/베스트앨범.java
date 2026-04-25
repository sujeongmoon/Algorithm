import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genreFrequencyMap = new HashMap<>(); // 장르, 장르별로 얼마나 재생됐는지
        HashMap<String, ArrayList<int[]>> songFrequencyMap = new HashMap<>(); // 장르, [노래번호, 노래가 얼마나 재생됐는지]
        
        // 장르별로 얼마나 플레이됐는지 누적 빈도 map 생성
        for (int i = 0; i < genres.length; i++) {
            genreFrequencyMap.put(genres[i], genreFrequencyMap.getOrDefault(genres[i], 0) + plays[i]);
            
            // 해당 장르가 songFrequencyMap에 안 들어가있다면 put을 새로 넣고(index와 plays[i]를 key, value로 넣어줌.), 이미 있다면 value인 ArrayList에 plays를 add
            // if (!songFrequencyMap.containsKey(genres[i])) {
            //     songFrequencyMap.put(genres[i], new ArrayList<>());
            // } 
            // songFrequencyMap.get(genres[i]).add(new int[]{i, plays[i]});
            songFrequencyMap.computeIfAbsent(genres[i], x -> new ArrayList<>()).add(new int[]{i, plays[i]}); // i가 고유번호
        }
        
//         // 1. genreFrequencyMap, value값 기준으로 내림차순 sort       
//         Stream<Map.Entry<String, Integer>> sortGenre = genreFrequencyMap.entrySet()
//             .stream()
//             .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
//         sortGenre.forEach(entry -> {
//             Stream<int[]> sortSong = songFrequencyMap.get(entry.getKey())
//                 .stream()
//                 .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
//                 .limit(2);
//             sortSong.forEach(song -> answer.add(song[0]));
//         });
        // return answer.stream().mapToInt(Integer::intValue).toArray();
        
        
        //2. 나눠서..
        // 장르별 총 재생 횟수를 기준으로 장르 이름 정렬.
        List<String> sortedGenres = genreFrequencyMap.entrySet().stream().sorted((o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        })
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        List<Integer> resultList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = songFrequencyMap.get(genre);
            
            songs.sort((o1,o2) -> {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o2[1], o1[1]);
            });
            
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                resultList.add(songs.get(i)[0]);
            }
            
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
        
        
        
        
        
        
   
    }
}