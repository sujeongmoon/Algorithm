import java.util.*;

class Solution {
    
    static int staticM;
    static int staticN;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        // 벽에 한 번 맞히고 공에 맞히기 연습
        // 최소 얼마의 거리를 굴러가야하는지
        
        // m 가로, n 세로, startX startY 쳐야하는 공의 좌표, balls 매 회마다 목표로 해야하는 공들의 위치 좌표
        staticM = m;
        staticN = n;

        for (int i = 0; i < balls.length; i++) {
            int goalX = balls[i][0];
            int goalY = balls[i][1];

            List<Long> candidates = new ArrayList<>();

            // 아래벽
            if (!(startX == goalX && goalY < startY)) {
                long dx = startX - goalX;
                long dy = startY + goalY;
                candidates.add(dx*dx + dy*dy);
            }

            // 위벽
            if (!(startX == goalX && goalY > startY)) {
                long dx = startX - goalX;
                long dy = 2 * n - goalY - startY;
                candidates.add(dx*dx + dy*dy);
            }

            // 왼벽
            if (!(startY == goalY && goalX < startX)) {
                long dx = goalX + startX;
                long dy = startY - goalY;
                candidates.add(dx*dx + dy*dy);
            }

            // 오른벽
            if (!(startY == goalY && goalX > startX)) {
                long dx = 2 * m - goalX - startX;
                long dy = startY - goalY;
                candidates.add(dx*dx + dy*dy);
            }

            answer[i] = (int)(long) Collections.min(candidates);
        }
        
        return answer;
        
    }
}