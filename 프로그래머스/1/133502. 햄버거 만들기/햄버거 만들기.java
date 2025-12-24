import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        //1231 순서로.
        //스택으로 쌓은다음에, 계속 뺐다가 아니면 걍 다 넣기.
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int ing : ingredient) {
            stack.push(ing);
            
            if (stack.size() >= 4) {
                int bread2 = stack.pop();
                if (bread2 != 1) {
                    stack.push(bread2);
                    continue;
                }
                int meat = stack.pop();
                if (meat != 3) {
                    stack.push(meat);
                    stack.push(bread2);
                    continue;
                }
                int veg = stack.pop();
                if (veg != 2) {
                    stack.push(veg);
                    stack.push(meat);
                    stack.push(bread2);
                    continue;
                }
                int bread1 = stack.pop();
                if (bread1 != 1) {
                    stack.push(bread1);
                    stack.push(veg);
                    stack.push(meat);
                    stack.push(bread2);
                    continue;
                }
                answer++;
            }
            
        }
        
        return answer;
    }
}