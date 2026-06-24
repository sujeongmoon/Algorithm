import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        
        int[][] max_dp = new int[arr.length / 2 + 1][arr.length / 2 + 1]; // 각각 max값을 더한 dp식 - i부터 j까지
        int[][] min_dp = new int[arr.length / 2 + 1][arr.length / 2 + 1]; // 각각 min값을 더한 dp식 - i부터 j까지
        String[] operator = new String[arr.length / 2];
        
        int numIndex = 0; // 숫자 인덱스
        int opIndex = 0; // 연산자 인덱스
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i].equals("+") || arr[i].equals("-")) {
                //연산자일 경우
                operator[opIndex] = arr[i];
                opIndex++;
                continue;
            }
            
            // 숫자인 경우
            max_dp[numIndex][numIndex] = Integer.parseInt(arr[i]);
            min_dp[numIndex][numIndex] = Integer.parseInt(arr[i]);
            numIndex++;
             
        }
        
        // length
        for (int length = 1; length < max_dp.length; length++) {
            
            // 시작점 i는 0부터, 범위를 벗어나지 않을 때까지 돈다
            for (int i = 0; i < max_dp.length - length; i++) {
                int j = i + length; // 끝점 j를 정해줌
                
                // 연산자의 경우, i부터 j까지가 들어가는 인덱스임
                // k를 기준으로 연산
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    
                    String nowOp = operator[k];
                    
                    // 더하기인 경우
                    if (nowOp.equals("+")) {
                        
                        // 가장 큰 값은 큰 거 더하기 큰 거
                        max = Math.max(max, max_dp[i][k] + max_dp[k+1][j]);  
                        // 가장 작은 값은 작은 거 더하기 작은 거
                        min = Math.min(min, min_dp[i][k] + min_dp[k+1][j]);
                        
                        
                    } else { // 빼기인 경우
                        
                        // 가장 큰 값은 큰 거 빼기 작은 거
                        max = Math.max(max, max_dp[i][k] - min_dp[k+1][j]);  
                        // 가장 작은 값은 작은 거 빼기 큰 거
                        min = Math.min(min, min_dp[i][k] - max_dp[k+1][j]);
                        
                    }
                    
                }
                
                max_dp[i][j] = max;
                min_dp[i][j] = min;
                
            }
            
        }
             
        answer = max_dp[0][max_dp.length - 1];
        
        return answer;
    }
}