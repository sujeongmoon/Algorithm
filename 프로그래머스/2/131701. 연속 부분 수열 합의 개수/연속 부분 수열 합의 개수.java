import java.util.*;

class Solution {
    public int solution(int[] elements) {

        // dp
        int[][] dp = new int[elements.length - 1][elements.length]; // 연속되는 각 값들을 더한 이차원 배열
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            dp[0][i] = elements[i];
            set.add(elements[i]);
        }
        
        for (int i = 1; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length; j++) {
                dp[i][j] = dp[i-1][j] + dp[0][(j+i) % elements.length];
                set.add(dp[i][j]);
                    
            }
        }
        
        return set.size() + 1; // 전체를 더한 값 + 1
        
    }
}