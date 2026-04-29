import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (s.equals("I")) {
                set.add(num);
            } else if (s.equals("D")) {
                if (!set.isEmpty()) {
                    if (num == 1) {
                        // 최댓값
                        set.pollLast();
                    } else if (num == -1) {
                        // 최솟값
                        set.pollFirst();
                    }
                }
            }
        }
        
        if (!set.isEmpty()) {
            answer[0] = set.last();
            answer[1] = set.first();
        }
        
        return answer;
    }
}