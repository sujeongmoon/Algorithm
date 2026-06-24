import java.util.*;

class Solution {
    
    public static int[] dr;
    public static int[] dc;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        dr = new int[] {1, -1, 0, 0};
        dc = new int[] {0, 0, 1, -1};
        
        // 다각형의 둘레를 따라 이동
        // 캐틱터 XY에서 itemXY까지 이동할 때, 이동해야 하는 가장 짧은 거리
        // recteangle에는 좌하단xy, 우상단xy가 있음
        
        
        // 일단 5050의 전체 좌표를 만들고. 갈 수 있는 길 먼저 짜보기. -> 100 100으로
        int[][] map = new int[102][102];
        boolean[][] isVisited = new boolean[102][102];
        
        for (int i = 0; i < rectangle.length; i++) {
            
            int ldX = rectangle[i][0] * 2;
            int ldY = rectangle[i][1] * 2;
            int ruX = rectangle[i][2] * 2;
            int ruY = rectangle[i][3] * 2;
            
            // X좌표 돌기
            for (int j = ldX; j <= ruX; j++) {
                // 윗변
                if (map[ruY][j] == 0) {
                    map[ruY][j] = 1;
                }
                // 아랫변
                if (map[ldY][j] == 0) {
                    map[ldY][j] = 1;
                }
            }
            
            // Y좌표 돌기
            for (int j = ldY; j <= ruY; j++) {
                // 좌변
                if (map[j][ldX] == 0) {
                    map[j][ldX] = 1;
                }
                // 우변
                if (map[j][ruX] == 0) {
                    map[j][ruX] = 1;
                }
            }
            
            // 속 돌기
            for (int j = ldY + 1; j < ruY; j++) {
                for (int k = ldX + 1; k < ruX; k++) {  
                    map[j][k] = 2;
                }
            }
        }
        
        // BFS로 돌기
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {characterY * 2, characterX * 2, 0});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            //만약 찾았으면 리턴
            if (now[0] == itemY * 2 && now[1] == itemX * 2) {
                return now[2] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dr[i];
                int nextX = now[1] + dc[i];
                
                if (map[nextY][nextX] == 1 && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    queue.offer(new int[] {nextY, nextX, now[2]+1});
                }
            }
            
        }
        
        
        return answer;
    }
}