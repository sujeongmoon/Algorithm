import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // String answer = "";
        
        Queue<String> cards1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new ArrayDeque<>(Arrays.asList(cards2));
        
        for (String str : goal) {
            if (str.equals(cards1Queue.peek())){
                cards1Queue.poll();
                continue;
            } else if (str.equals(cards2Queue.peek())) {
                cards2Queue.poll();
                continue;
            }
            return "No";
        }
                
        return "Yes";
    }
}