import java.util.*;

class Solution {
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new ArrayList<>();
    
    private void dfs(String cur) {
        PriorityQueue<String> pq = graph.get(cur);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        route.add(cur);
        
    }
    public String[] solution(String[][] tickets) {
        
        
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            graph.putIfAbsent(from,new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        
        dfs("ICN");
        
        Collections.reverse(route);
        return route.toArray(new String[0]);

    }
}