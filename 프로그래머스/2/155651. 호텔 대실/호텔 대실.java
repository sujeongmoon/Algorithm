import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] book_time_sort = new int[book_time.length][4]; //시작시간/시작분/끝나는시간/끝나는분
        for (int i = 0; i < book_time.length; i++) {
            StringTokenizer st = new StringTokenizer(book_time[i][0]);
            int startHour = Integer.parseInt(st.nextToken(":"));
            int startMin = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(book_time[i][1]);
            int endHour = Integer.parseInt(st.nextToken(":"));
            int endMin = Integer.parseInt(st.nextToken()) + 10;
            
            if (endMin >= 60) {
                endHour++;
                endMin -= 60;
            }
            
            book_time_sort[i][0] = startHour;
            book_time_sort[i][1] = startMin;
            book_time_sort[i][2] = endHour;
            book_time_sort[i][3] = endMin;
            
        }
        
        Arrays.sort(book_time_sort,
                    (o1, o2) -> {
                        if (o1[0] != o2[0]) return o1[0] - o2[0];
                        return o1[1] - o2[1];
                    });
        

        int nowRoomCount = 0; // 현재 방 갯수
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) return o1[2] - o2[2];
            return o1[3] - o2[3];
        });
        for (int[] now : book_time_sort) {
            if (!pq.isEmpty()) {
              int[] top = pq.peek();
                if (top[2] < now[0] || (top[2] == now[0] && top[3] <= now[1])) {
                    pq.poll();
                }
            }
            pq.offer(now);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}