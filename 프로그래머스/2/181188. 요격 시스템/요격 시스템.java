import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 입력: 이차원배열(int)
        // A나라는 x축에 평행(폭격미사일)
        // B나라는 특정 x좌표에서 y축에 수평(주황색) // 요격미사일을 최소로해서 모든 폭격미사일을 요격
        // s랑 e에서 발사하는 요격미사일로는 요격할 수 없다 -> 실수인 x좌표에서도 발사할 수 있다.
        
        // 모든 폭격미사일 요격하기 위해 필요한 요격 미사일 수를 구해라.
        
        
        // 일단 가장 짧은 것부터 찾고, 겹치는 걸 찾으면 될 것 같은데
        // [0] + 1 <= [1] 여야함 (끊기면안됨) => 잘못생각(예전에 풀었던 비슷한 유형을 떠올렸짐나 접근 방식이 틀렸다)
        
        Arrays.sort(targets, (o1, o2) -> {
            // 종료시점이 빠른 순서대로 정렬
            // 제일 처음부터 훑되, 가장 뒤에서 쏘는 게 유리 (겹칠 가능성이 더 높아짐)
            // 끝나는 기준으로 정렬하는 게 중요
            return Integer.compare(o1[1], o2[1]);
        });

        int last = 0;
        
        for (int i = 0; i < targets.length; i++) {
            if (last <= targets[i][0]) {
                answer++;
                last = targets[i][1];
            }
        }
        
        return answer;
    }
}