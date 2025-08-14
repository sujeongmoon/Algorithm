// 

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        // Character[] characterArray = s.chars()
        //     .mapToObj(c->(char)c)
        //     .toArray(Character[]::new);
        
        char[] charArray = s.toCharArray();
        
        // for (int i = 0; i < characterArray.length; i++) {
        //     if (characterArray[i].equals('(')) {
        //         stack.push(characterArray[i]);
        //     } else if(stack.size() == 0) {
        //         return false;
        //     } else {
        //         stack.pop();
        //     }
        // }
        
        for (char c : charArray) {
            if ((c == '(')) {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}