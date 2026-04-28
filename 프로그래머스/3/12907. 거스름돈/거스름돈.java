class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        // dp
        long[] dp = new long[n+1];
        
        // 0원을 만드는 방법은 아무 것도 넣지 않는 1
        dp[0] = 1;
        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j < n+1; j++) {
                dp[j] = (dp[j] + dp[j-money[i]]) % 1000000007;
            }
        }
    
        answer = (int)dp[n];
        
        return answer;
    }
}