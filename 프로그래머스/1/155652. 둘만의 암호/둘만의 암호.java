import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c ++;
                
                while (set.contains(c) || c > 'z') {
                    c++;
                    if (c > 'z') {
                        c = 'a';
                    }
                    
                }
                
                
                // if (set.contains(c)) {
                //     c++;
                // }
                // if (c > 'z') {
                //     c = 'a';
                // }
                // while (set.contains(c)) {
                //     c++;
                // }
                 
            }
            answer += c;
        }
        
        return answer;
    }
}