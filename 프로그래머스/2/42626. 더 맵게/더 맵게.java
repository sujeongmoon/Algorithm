import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 레오는 스코빌 지수를 K 이상으로 만들고 싶다. 가장 낮은 두 개의 음식을 합친다!
        
        // 1. 오름차순 정렬인 큐에 넣는다
        // 2. 두개를 빼서 합치고 다시 큐에 넣는다
        // 3. answer을 더한다 -> 나오는 게 K 이상이 될 때까지 반복
        // 4. K 이상인 게 나오면 끝, answer리턴
        // 4-1. 만약 큐의 개수가 하나가 되고 K 이상이 되지 않았다면, -1을 리턴
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 자동으로 올므차순 정렬
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        // 1이면 리턴
        while(pq.size() != 1) {
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            // K 이상인 게 나오면 끝
            if (s1 >= K) {
                return answer;
            }
            
            int newS = s1 + (s2 * 2);
            pq.offer(newS);
            answer++;
            
        }
        
        if (pq.poll() >= K) {
            return answer;
        } else {
            return -1;
        }

    }
}