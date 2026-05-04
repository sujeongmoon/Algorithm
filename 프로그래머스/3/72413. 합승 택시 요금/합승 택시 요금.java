import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // n: 지점의 개수
        // s: 출발지점
        // a, b : 각각 도착지점
        // fares: 지점 사이 택시요금 [노드, 연결노드, 예상요금], 양방향
        // answer: 최저 예상 택시요금 / 각자 이동하는 게 더 낮으면 합승 x
        int answer = Integer.MAX_VALUE;
        
        int[][] arr = new int[n+1][n+1]; // 1에서 n까지의 노드, 내용은 점수, 아닌경우 Integer.MAX_VALUE
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        } // 전체값 maxvalue로 초기화
        
        for (int i = 0; i < fares.length; i++) {
            // arr 값 채우기
            arr[fares[i][0]][fares[i][1]] = fares[i][2]; 
            arr[fares[i][1]][fares[i][0]] = fares[i][2]; 
        }
        
        int[] distFromS = new int[n+1]; // s에서부터 환승노드까지의 거리
        int[] distToA = new int[n+1]; // 환승노드에서 A까지의 거리
        int[] distToB = new int[n+1]; // 환승노드에서 B까지의 거리
        
        Arrays.fill(distFromS, Integer.MAX_VALUE);
        Arrays.fill(distToA, Integer.MAX_VALUE);
        Arrays.fill(distToB, Integer.MAX_VALUE);
        
        // 알고있는 거리는 dist 배열에서도 0으로 설정해줘야함
        distFromS[s] = 0;
        distToA[a] = 0;
        distToB[b] = 0;
        
        // PriorityQueue<int[]> pq = new PriorityQueue<>(); -> int객체라서 안됨
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[1])); // int[x]를 x[1]기준으로 비교 (x[1]은 점수) // 여기서 a: 변수명충돌
        
        
        // distFromS 채우기
        pq.offer(new int[] {s, 0}); // pq에 초기값 s,0 offer
        while (!pq.isEmpty()) {
            
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];
            
            // 이미 더 짧은 거리가 채워져있는 경우
            if (nowCost > distFromS[nowNode]) {
                continue;
            }
            
            for (int i = 1; i <= n; i++) {
                
                // 연결 안 된 경우 스킵
                if (arr[nowNode][i] == Integer.MAX_VALUE) {
                    continue;
                }
                
                
                int newCost = arr[nowNode][i] + nowCost; // 새로운 값
                
                // 새로 구한 비용이 최저 비용이라면
                if (newCost < distFromS[i]) {
                    distFromS[i] = newCost;
                    pq.offer(new int[] {i, newCost});
                }
            } 
        }

        
        // distToA
        pq.offer(new int[] {a, 0}); // pq에 초기값 a, 0 offer
        while (!pq.isEmpty()) {
            
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];
            
            // 이미 더 짧은 거리가 채워져있는 경우
            if (nowCost > distToA[nowNode]) {
                continue;
            }
            
            for (int i = 1; i <= n; i++) {
                
                // 연결 안 된 경우 스킵
                if (arr[nowNode][i] == Integer.MAX_VALUE) {
                    continue;
                }
                
                int newCost = arr[nowNode][i] + nowCost; // 새로운 값
                
                // 새로 구한 비용이 최저 비용이라면
                if (newCost < distToA[i]) {
                    distToA[i] = newCost;
                    pq.offer(new int[] {i, newCost});
                }
            } 
        }
        
        // distToB
        pq.offer(new int[] {b, 0}); // pq에 초기값 b,0 offer
        while (!pq.isEmpty()) {
            
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];
            
            // 이미 더 짧은 거리가 채워져있는 경우
            if (nowCost > distToB[nowNode]) {
                continue;
            }
            
            for (int i = 1; i <= n; i++) {
                
                // 연결 안 된 경우 스킵
                if (arr[nowNode][i] == Integer.MAX_VALUE) {
                    continue;
                }
                
                int newCost = arr[nowNode][i] + nowCost; // 새로운 값
                
                // 새로 구한 비용이 최저 비용이라면
                if (newCost < distToB[i]) {
                    distToB[i] = newCost;
                    pq.offer(new int[] {i, newCost});
                }
            } 
        }
        
        
        for (int i = 1; i <= n; i++) {
            if ((distFromS[i] == Integer.MAX_VALUE) || (distToA[i] == Integer.MAX_VALUE) || (distToB[i] == Integer.MAX_VALUE)) {
                continue;
            }
            int sum = distFromS[i] + distToA[i] + distToB[i];
            answer = Math.min(sum, answer);
            System.out.println(sum);
        }

        return answer;
    }
}