import java.util.*;

class Solution {
    
    static int[][] staticLand;
    static boolean[][] isVisited;
    static HashMap<Integer, Integer> map; // id와 크기를 짝지음
    static HashSet<Integer> set; // id목록
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        staticLand = land;
        int n = land.length; // row
        int m = land[0].length; // col
        isVisited = new boolean[n][m];
        map = new HashMap<>();
        int id = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (staticLand[i][j] != 0 && isVisited[i][j] == false) {
                    int totalSize = dfs(i, j, id, 1);
                    map.put(id, totalSize);
                    id++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            set = new HashSet<>(); // 매 시추 시마다 set 초기화
            int now = 0;
            for (int j = 0; j < n; j++) {
                if (staticLand[j][i] != 0) {
                    
                    if (!set.contains(staticLand[j][i])) {
                        // // 아직 안 더한 경우
                        now += map.get(staticLand[j][i]);
                        set.add(staticLand[j][i]);
                    }
                }  
            }

            answer = Math.max(now, answer);
        }
        
        return answer;
    }
    
    static int dfs(int r, int c, int id, int now) {
        if (r == staticLand.length || r == -1 || c == staticLand[0].length || c == -1) {
            return 0;
        }
        
        if (isVisited[r][c] == true || staticLand[r][c] == 0) {
            return 0;
        }
        
        staticLand[r][c] = id;
        isVisited[r][c] = true;
        
        int size = 1;
        
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            
            size += dfs(nextR, nextC, id, now+1);
        }
        
        return size;
        
        
        
    }
}