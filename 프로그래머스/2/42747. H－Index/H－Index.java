import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations[citations.length-1];
        
        // 오름차순 정렬
        Arrays.sort(citations);
        
        // 01356
        
        for (int  i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            
            if (citations[i] >= h) {
                return h; 
            }       
        }

        return 0;
    }
}