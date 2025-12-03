import java.util.*;

class Solution {
    
    int[][] dungeonArrays;
    int[] orderArrays;
    int maxOrder = 0;
    
    void dfs(int nowK, int idx, int nowOrder) {
        
        int nextK = nowK - dungeonArrays[idx][1];
        maxOrder = Math.max(nowOrder, maxOrder);
        
        for (int i = 0; i < dungeonArrays.length; i++) {
            // orderArrays[idx] = nowOrder; 
            
            if (orderArrays[i]!=0) {
                continue;
            }
            
            if (nextK < dungeonArrays[i][0]) {
                continue;
            }
            
            if (nextK - dungeonArrays[i][1] < 0) {
                continue;
            }
                
            orderArrays[i] = nowOrder+1;    
            dfs(nextK, i, nowOrder+1);
            orderArrays[i] = 0;  
        }
    }
    
    
    public int solution(int k, int[][] dungeons) {

        dungeonArrays = dungeons;
        orderArrays = new int[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            orderArrays[i] = 1;    
            dfs(k, i, 1);
            orderArrays[i] = 0;    
        }
        
        return maxOrder;
    }
}