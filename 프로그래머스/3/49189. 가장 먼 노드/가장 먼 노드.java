import java.util.*;

class Solution {
    
    static HashMap<Integer, Integer> bfs(ArrayList<Integer>[] adjList, HashMap<Integer, Integer> distanceMap) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        distanceMap.put(1, 0);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : adjList[now]) {
                if (distanceMap.containsKey(next)) { // containsKey만 찾으면 됨
                    continue;
                }
                
                distanceMap.put(next, distanceMap.get(now) + 1);
                queue.offer(next);
                
            }
        }
        return distanceMap;
    }
                
                    

    
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 노드는 1부터 n까지... 1번 노드에서 가장 멀리 떨어진 노드의 개수 (최단경로로 가장 멀리 떨어진 노드)
        // 일단 인접리스트로 vertex를ㄹ 만들고, 1번노드는 각 노드까지 최단거리가 얼마인지 다 담아야 함. 
        // 방문노드 체크를 distance 배열로..? 아니 ...
        // 간선은 양방향 (넣을 때 주의))
        
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        // 노드, 거리
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        
        for (int i = 0; i < n+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
    
        distanceMap = bfs(adjList, distanceMap);
        
        int maxVal = Collections.max(distanceMap.values());
        // stream 문법
        answer = (int) distanceMap.values().stream()
                .filter(v -> v == maxVal)
                .count();
        
        return answer;
    }
}