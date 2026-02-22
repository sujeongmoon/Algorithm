import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        char[] arrX = X.toCharArray();
        char[] arrY = Y.toCharArray();
        
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        
        ArrayDeque<Character> stackX = new ArrayDeque<>();
        ArrayDeque<Character> stackY = new ArrayDeque<>();
        
        for (char c  : arrX) {
            stackX.push(c);
        }
        
        for (char c  : arrY) {
            stackY.push(c);
        }
        
        while (!stackX.isEmpty() && !stackY.isEmpty()) {
            if (stackX.peek() > stackY.peek()) {
                stackX.pop();
            } else if (stackX.peek() < stackY.peek()) {
                stackY.pop();
            } else if (stackX.peek() == stackY.peek()) {
                if (sb.length() == 0 && stackX.peek()=='0') {
                    return "0";
                }
                sb.append(stackX.pop());
                stackY.pop();
            }
        }
        
        if (sb.toString().equals("")) {
            return "-1";
        } else {
            return sb.toString();
        }
        
    }
}

