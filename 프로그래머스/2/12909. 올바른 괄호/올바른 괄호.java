import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack stack = new Stack();
        char c = ' ';
        
//         (이 들어오면 push, )이 들어오면 pop, 에러가 나거나 스택에 아직 (이 남아있으면 false 리턴
        
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            if (c == ')' && stack.size() == 0) {
                return false;
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        
        if (stack.size() != 0) {
            return false;
        }

        return answer;
    }
}