import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 컴퓨터 시스템의 자원을 효율적으로 관리
        // 특정 프로세스가 몇 번째로 실행되는지 알아내면 됨
        
        // 내가 지금 가장 우선순위가 낮을 때 나간다.
        // 만약 낮은 게 두 개 이상이라도, 나간다.\
        
        // priorities 배열을 while로 돌면서 location 인덱스가 -1이 되면 리턴되도록
        // 1. 일단 최대값을 찾는다. sort하고 마지막 열로
        // 2. 1223 이고, 그러면 3이 나올 때까지 계속해서 인덱스 +1해가고,
        // 3. 최대값은 따로 만든 배열에다가 -1 인덱스 해가면서 찾으면 된다.
        
        // 111119라면, 배열은 계속 돌고있고, 최대값 찾고 -1로 값 만들 떄마다 answer을 ++하고.
        
        int[] sortP = priorities.clone();
        Arrays.sort(sortP);
        
        int sortIndex = sortP.length - 1; // 현재 가장 높은 우선순위를 나타내는 인덱스값
        
        // 큐를 만들자
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        
        while (!queue.isEmpty()) {
            
            int[] now = queue.poll();
            
            // 값을 빼야 할 경우
            if (now[0] == sortP[sortIndex]) {
                sortIndex--;
                answer++;
                // 다시 값 안 넣음
                if (now[1] == location) {
                    return answer;
                }
                
                continue;
            }
            queue.offer(now);
        }
        
        return answer;
    }
}