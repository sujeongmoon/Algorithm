import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = {};
        List<Integer> answerList = new LinkedList<>();
        int answer = 0;
        
        
        // 하루가 지날수록 더하고, 더하고. map을 만들어서 비교해도 될 것 같은데
        // progresses length만큼 for문 돌리고, 그 speeds만큼 더해지게 -> 이중for문
        
        Queue<Integer> progressesQueue = Arrays.stream(progresses).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> speedsQueue = Arrays.stream(speeds).boxed().collect(Collectors.toCollection(LinkedList::new));
        
        int i = 0;
        
        while(true) {
            
            
            // 앞에 게 일자리에서 100을 넘으면 -> 일단 새로 하나가 추가되는 거고, 혹시 다음 것도 100 넘으면 추가해야됨..
//             if (progressQueue.peek() + speedsQueue.peek() * i >= 100) {
//                 while (progressQueue.peek + speedsQueue.peek
//             }
                       
            while (!progressesQueue.isEmpty() && progressesQueue.peek() + speedsQueue.peek() * i < 100) {
                i+=1;
            }
            while (!progressesQueue.isEmpty() && progressesQueue.peek() + speedsQueue.peek() * i >= 100) {
                answer+=1;
                progressesQueue.poll();
                speedsQueue.poll();
            }
                        
            answerList.add(answer);
            
            if (progressesQueue.isEmpty()) {
                break;
            }
            answer = 0;
        }
        
        // return answerList.toArray(new Integer[answerList.size()]);
        return answerList.stream().mapToInt(Integer::intValue).toArray();


    }
}