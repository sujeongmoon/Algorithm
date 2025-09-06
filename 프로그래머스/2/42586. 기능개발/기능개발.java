import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length; // 작업 개수
        
        //남은 날 담은 배열
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int maxDay = daysLeft[0];
        
        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) {
                count++; // 배포 가능일이 가장 늦은 배포 가능일보다 빠르면, 작업을 count개만큼 배포(이미 뒤에 게 완료됐으니까)
            } else {
                answer.add(count);
                count = 1; // ++된 count 다시 1개로 되돌려주기
                maxDay = daysLeft[i];
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}