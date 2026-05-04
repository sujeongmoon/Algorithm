import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (s.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                
            } else if (s.equals("D")) {
                if (!map.isEmpty()) {
                    Map.Entry<Integer, Integer> entry = null; // 제너릭타입 명시해줘야함, 안 하면 incompatible types 에러, 초기값 명시도 해주기
                    if (num == 1) {
                        // 최댓값
                        entry = map.lastEntry();
                    } else if (num == -1) {
                        // 최솟값
                        entry = map.firstEntry();
                    }
                    
                    map.put(entry.getKey(), entry.getValue() - 1);
                    if ((entry.getValue() - 1) == 0) { //entry가 예전 값을 가리키고 있음(lastEntry()/firstEntry() 메소드 특성)
                        map.remove(entry.getKey());
                    }
                }
            }
        }
        
        if (!map.isEmpty()) {
            answer[0] = map.lastEntry().getKey();
            answer[1] = map.firstEntry().getKey();
        }
        
        return answer;
    }
}