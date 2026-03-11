import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], (map.getOrDefault(tangerine[i], 0) + 1));
        }  
        
        List<Integer> list = map.values().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            answer++;
            
            if (k <= 0) {
                return answer;
            }
        }
        
        return answer;
    }
}