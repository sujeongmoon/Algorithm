class Solution {
    public int[] solution(int n) {
        
        int[] rx = {1, 0, -1};
        int[] ry = {0, 1, -1};
        
        int[] answer = new int[(n*(n+1))/2];
        
        int[][] triangle = new int[n][];
        
        for (int i = 1; i <= n; i++) {
            triangle[i-1] = new int[i];
        }
        
        int x = 0;
        int y = 0;
        int now = 0;
        
        for (int i = 1; i <= (n*(n+1))/2; i++) {
            
            triangle[x][y] = i;
            
            if (x+rx[now] < 0 || x+rx[now] >= n 
                || y+ry[now] < 0 || y+ry[now] >= triangle[x+rx[now]].length
                 || triangle[x+rx[now]][y+ry[now]] != 0
               ) {
                
                now = (now+1)%3;
            }
            
            x += rx[now];
            y += ry[now];
            
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++, idx++) {
                answer[idx] = triangle[i][j];
           
            }
        }

        return answer;
    }
}