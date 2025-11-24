import java.util.*;

class Solution {
    
    static class Node{
        int destVillage;
        int cost;
        
        public Node(int destVillage, int cost) {
            this.destVillage = destVillage;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2])); // 반대도 해줘야 함
        }
        
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[1] = 0;
        
        // 도로를 지나야 합니다. 시간은 도로별로 다름 -> 다익스트라 (가중치가 있다)
        // N : 마을 개수, K : 최대 배달 시간, road : 도로의 정보
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq. add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (distance[now.destVillage] < now.cost) {
                continue;
            }
            
            for (Node next : adjList[now.destVillage]) {
                if (distance[next.destVillage] > now.cost + next.cost) {
                    distance[next.destVillage] = now.cost + next.cost;
                    pq.add(new Node(next.destVillage, distance[next.destVillage]));
                }
            }
        }
        
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] <= K) {
                answer ++;
            }
        }

        return answer;
    }
}