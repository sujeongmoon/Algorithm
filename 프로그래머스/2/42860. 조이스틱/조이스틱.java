import java.util.*;


class Solution {
    public int solution(String name) {
        
        // 좌우 움직이기
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            
            int nextIdx = i + 1;
            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
                nextIdx++; // A 끝까지 nextIdx++
            }
            
            int routeA = i * 2 + (name.length() - nextIdx); // 앞에 갔다가 A를 마주치면 뒤로 돌아가기
            int routeB = (name.length() - nextIdx) * 2 + i; // 뒤에 먼저 갔다가 A를 마주치면 앞으로 돌아가기 
            
            int minRoute = Math.min(routeA, routeB);
            move = Math.min(move, minRoute);
        }
        
        // 상하 움직이기
        for (int i = 0; i < name.length(); i++) {
            
            char c = name.charAt(i);
            move += Math.min((c - 'A'), (26 + 'A' - c));
            
        }
        
        return move;
    }
}