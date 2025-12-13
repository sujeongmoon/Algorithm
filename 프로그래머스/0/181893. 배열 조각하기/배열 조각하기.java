import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
            
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int x : arr) answerList.add(x);
        
        // 짝수 인덱스에서는 i앞부분, 홀수 인덱스는 i의 앞부분을 담아서 넣어줌.
        
        for (int i = 0; i < query.length; i++) {
            if (i%2==0) {// 짝수인 경우, 앞부분을 남김 -> 뒷부분을 날림
                for (int j = answerList.size()-1; j > query[i]; j--) {
                    answerList.remove(j);
                }
            } else {
                for (int j = 0; j < query[i]; j++) {
                    answerList.remove(0);
                }
            }
        }
        
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}