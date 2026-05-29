import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left + 1)];
            
        int r = (int)(left / n);
        int c = (int)(left % n);
            
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max(r,c) + 1;
            c++;
            if (c >= n) {
                c -= n;
                r++;
            }
        }
        
        return answer;
    }
}