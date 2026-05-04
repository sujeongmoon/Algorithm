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
                        map.pollLastEntry();
                    } else if (num == -1) {
                        // 최솟값
                        map.pollFirstEntry();
                    }
                }
            }
        }
        
        if (!set.isEmpty()) {
            answer[0] = map.peekLast().getKey();
            answer[1] = map.peekFirst().getKey;
        }
        
        return answer;
    }
}