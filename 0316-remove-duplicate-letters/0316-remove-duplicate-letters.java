import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {

        StringBuilder sb = new StringBuilder();
        
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }
 
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}