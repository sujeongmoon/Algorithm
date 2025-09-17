import java.util.*;

class Solution {
    public int[] solution(int n) {
        // int[] answer = {};
        
        ArrayList<Integer> collats = new ArrayList<>();
        
        while(n!=1) {
            collats.add(n);
            
            if (n % 2 == 0){
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        
        collats.add(n);
        
        return collats.stream().mapToInt(Integer::intValue).toArray();
    }
}