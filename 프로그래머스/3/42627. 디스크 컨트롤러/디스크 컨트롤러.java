import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 우선순위 디스크 컨트롤러
        
        // 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장 (대기 큐)
        // 1. 소요시간이 짧고 2. 요청 시간이 빠르고 3. 작업의 번호가 작은 것 순서대로 일을 함
        // 일단 큐에 넣고, 우선순위대로 수행
        
        // int는 들어오는시간이랑 걸리는시간, 작업 번호 순서로 저장
        
        // 작업순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] arr) -> arr[1])
            .thenComparingInt(arr -> arr[0])
            .thenComparingInt(arr -> arr[2])
        );
        
        int time = 0;
        
        // jobs를 작업이 요청되는 시점에 따라 정렬
        
        // 작업 순위 큐를 만들고, 대기 큐를 만든다
        // 들어오는 시간, (걸리는 시간), 작업 번호 순서로 저장
         
        // 대기 큐 
        PriorityQueue<int[]> taskQ = new PriorityQueue<>(
            Comparator.comparingInt((int[] arr) -> arr[0])
            .thenComparingInt(arr -> arr[2])
        );
        
        // 대기 큐에 저장
        for (int i = 0; i < jobs.length; i++) {
            taskQ.offer(new int[] {jobs[i][0], jobs[i][1], i}); // 들어오는 시간, 걸리는 시간, 작업 번호 순서
        }
        
        // 시간이 흘러갈 때, 만약에 해당 작업 순위 큐에 있는 순서랑 실제 시간이랑 같으면 큐에서 뺌
        // 작업 순위 큐와 대기 큐 둘 다 비기 전까진 끝나지 않음
        
        int sumTime = 0; // 전체 더한 시간 합
        
        while (!taskQ.isEmpty() || !pq.isEmpty()) {

            
            // 현재시간과 taskQ의 시간을 비교해서 작업 순위 큐에 넣기
            while (!taskQ.isEmpty() && taskQ.peek()[0] <= time) {
                pq.offer(taskQ.poll());
            }
            
            // pq가 없는 경우 다음 pq가 들어올 때까지 워프
            if (pq.isEmpty()) {
                time = taskQ.peek()[0];
                continue;
            }
            
            
            // pq 작업 완료하기
            int[] nowTask = pq.poll();
            time += nowTask[1];
            sumTime += (time - nowTask[0]);
            
        }
        
        answer = (int)(sumTime / jobs.length);
        return answer;
    }
}