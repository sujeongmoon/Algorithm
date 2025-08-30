import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder ss = new StringBuilder();
        ss.append(s);
        ss.append(s);
        
        String ssToString = ss.toString();
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                char c = ssToString.charAt(i+j);
                
                if (c == '(' || c == '[' || c=='{') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    break;
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                
                if (stack.isEmpty() && j == s.length() - 1) {
                    answer++;
                }
            }
            
        }
        
        
        return answer;
    }
}