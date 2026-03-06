class Solution {
    int solution(int[][] land) {
        
        int[][] dp = new int[land.length][land[0].length];
        
        dp[0] = land[0];
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                
                int temp = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == j) {
                        continue;
                    }
                    temp = Math.max(temp, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + temp;
                
            }
        }
        int answer = Math.max(Math.max(dp[dp.length-1][0],dp[dp.length-1][1]),Math.max(dp[dp.length-1][2],dp[dp.length-1][3]));
        return answer;
    }
}