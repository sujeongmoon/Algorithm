import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        
        for (int i = 0; i < arr.length-1; i++) {
            
            answer = answer * arr[i] / gcb(answer, arr[i]);
            
        }
        
        return answer;
    }
    
    
    static int gcb (int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcb(b, a%b);
    }
}