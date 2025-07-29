import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
 
        
        Stack<Integer> stack = new Stack<>();
//         배열에서 연속적으로 나타나는 숫자는 제거 -> 후에 나오는 건 중복도 괜찮음
       
        stack.push(arr[0]);

        for(int i : arr) {
            if(!(stack.peek().equals(i))) {
                stack.push(i);
            }
        }
        
        Integer[] answerObj = stack.toArray(new Integer[stack.size()]);
        int[] answer = new int[answerObj.length];
        
        for (int i = 0; i < answerObj.length; i++) {
            answer[i] = (int) answerObj[i];
        }

        return answer;
    }
}