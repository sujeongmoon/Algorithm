import java.util.*;

class Solution {
    
    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};
    
    
    public int solution(int[][] maps) {
        bfs(maps);
        
        return maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
    }
    
    public static void bfs(int[][] maps) {
        
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // 현재 도달해있는 칸의 좌표를 저장하는 큐
        queue.offer(new int[] {0, 0}); 
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i ++) {
                
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];
                
                // 0 미만이거나 length 이상인 경우 스킵
                if (nextR < 0 || nextR >= maps.length || nextC < 0 || nextC >= maps[0].length) {
                    continue;
                }
                // 막혀있거나 이미 방문한 경우는 스킵
                if (maps[nextR][nextC] != 1) {
                    continue;
                }
                
                
                // 해당 자리를 step 수로
                maps[nextR][nextC] = maps[now[0]][now[1]] + 1;
                // 큐에 넣기
                queue.offer(new int[] {nextR, nextC});
            }
            
        }
        
        return;

    }
}