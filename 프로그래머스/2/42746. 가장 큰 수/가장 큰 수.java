import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strArr, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            
            return order2.compareTo(order1); // 내림차순 정렬
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (String str: strArr) {
            sb.append(str);
        }
        
        String answer = sb.toString();
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
        
        
        
//         PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        
//         for (int num : numbers) {
//             pq.add(String.valueOf(num));
//         }
        
//         if (pq.peek().equals("0")) return "0";
        
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             sb.append(pq.poll());
//         }
        
//         return sb.toString();
    }
}