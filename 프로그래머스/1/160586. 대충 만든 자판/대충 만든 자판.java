import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (hashMap.containsKey(keymap[i].charAt(j)) && 
                    hashMap.get(keymap[i].charAt(j)) <= j+1) {
                        continue;
                    }
                hashMap.put(keymap[i].charAt(j), j+1);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int num = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int n = hashMap.getOrDefault(targets[i].charAt(j),-1);
                if (n == -1) {
                    num = -1;
                    break;
                }
                num += n;
            }
            answer[i] = num;
        }
    
        
        return answer;
    }
}