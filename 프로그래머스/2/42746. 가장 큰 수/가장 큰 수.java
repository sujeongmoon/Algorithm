import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        
        for (int num : numbers) {
            pq.add(String.valueOf(num));
        }
        
        if (pq.peek().equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}