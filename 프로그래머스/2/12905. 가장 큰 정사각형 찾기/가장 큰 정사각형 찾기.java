class Solution
{
    public int solution(int [][]board)
    {
        
        int[][] dp = board;

        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) { 
                
                if (dp[i][j] == 1) {
                    dp[i][j] += Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) { 
                
                answer = Math.max(answer, board[i][j]);
            }
        }
  
        return answer*answer;
    }
}