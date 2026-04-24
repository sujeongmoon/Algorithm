import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[] {6, 6};
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : win_nums){
            set.add(num);
        }
        
        int z = 0;
        int correct = 7;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                z++;
            } else if (set.contains(lottos[i])) {
                correct--;
            }
            
        }
        
        if ((correct - z) < 6) {
            answer[0] = correct - z;
        }
        
        if (correct < 6) {
            answer[1] = correct;
        }
        
        return answer;
    }
}