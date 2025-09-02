import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            // answer[i]가 떨어지면
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int j = stack.pop();
                
                //기간 값이 들어가야함
                answer[j] = i - j; 
            }
            stack.push(i);

        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = prices.length - 1 - j;
        }
        
        return answer;
    }
}