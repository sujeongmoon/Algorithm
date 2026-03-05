import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        
        int[][] dp = new int[triangle.length][];
        
        dp[0] = triangle[0];
        
        for (int i = 1; i < triangle.length; i++) {
            
            dp[i] = new int[triangle[i].length];
            
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == dp[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max((dp[i-1][j] + triangle[i][j]), (dp[i-1][j-1] + triangle[i][j]));
                }
            }
            
        }
        
        return Arrays.stream(dp[dp.length-1]).max().getAsInt();
    }
}