import java.util.*;

class Solution {
    public int solution(int[] elements) {

        // dp
        int[] dp = new int[elements.length]; // 연속되는 각 값들을 더한 이차원 배열
        HashSet<Integer> set = new HashSet<>(); // 더한 값을 넣는 set
        
        for (int i = 0; i < elements.length; i++) { // 몇 번까지 더할 건지
            for (int j = 0; j < elements.length; j++) { // 지금 dp의 몇 번째를 보고 있는지
                dp[j] += elements[(i+j) % elements.length];
                set.add(dp[j]);
                
            }
        }
        
        return set.size(); 
        
    }
}