import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 정렬을 하면 작은 값부터 순차적으로 탐색할 수 있어서 비율 계산이 깔끔해집니다.
        Arrays.sort(weights);
        
        // 각 몸무게의 등장 횟수를 저장할 맵
        Map<Double, Integer> map = new HashMap<>();
        
        for (int w : weights) {
            double weight = (double) w;
            
            // 현재 몸무게와 짝꿍이 될 수 있는 이전의 몸무게 조건들
            // (이미 정렬되어 있으므로 현재 몸무게보다 작거나 같은 비율들만 체크)
            if (map.containsKey(weight)) answer += map.get(weight);         // 1:1
            if (map.containsKey(weight * 2.0 / 3.0)) answer += map.get(weight * 2.0 / 3.0); // 3:2 (이전 값이 2, 현재 값이 3)
            if (map.containsKey(weight * 1.0 / 2.0)) answer += map.get(weight * 1.0 / 2.0); // 2:1 (이전 값이 2, 현재 값이 4)
            if (map.containsKey(weight * 3.0 / 4.0)) answer += map.get(weight * 3.0 / 4.0); // 4:3 (이전 값이 3, 현재 값이 4)
            
            // 현재 몸무게 개수 카운트 증가
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}