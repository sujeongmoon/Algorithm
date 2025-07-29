import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        Character[] characterArray = s.chars()
            .mapToObj(c->(char)c)
            .toArray(Character[]::new);
        
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i].equals('(')) {
                stack.push(characterArray[i]);
            } else if(stack.size() == 0) {
                return false;
            } else {
                stack.pop();
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}