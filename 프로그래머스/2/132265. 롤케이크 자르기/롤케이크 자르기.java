import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 오른쪽 주머니: 토핑 종류별 빈도수 (HashMap 사용)
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        // 왼쪽 주머니: 토핑 종류 저장 (HashSet 사용)
        Set<Integer> leftSet = new HashSet<>();
        
        // 롤케이크를 하나씩 왼쪽으로 넘기며 확인
        for (int t : topping) {
            // 1. 왼쪽 세트에 추가
            leftSet.add(t);
            
            // 2. 오른쪽 맵에서 하나 감소
            rightMap.put(t, rightMap.get(t) - 1);
            
            // 3. 오른쪽에서 해당 토핑이 0개가 되면 종류 자체가 사라진 것임
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }
            
            // 4. 왼쪽 종류 수와 오른쪽 종류 수가 같으면 정답!
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
            
            // 성능 최적화: 이미 왼쪽이 더 많아지기 시작하면 더 이상 볼 필요 없음 (선택사항)
            // if (leftSet.size() > rightMap.size()) break;
        }
        
        return answer;
    }
}