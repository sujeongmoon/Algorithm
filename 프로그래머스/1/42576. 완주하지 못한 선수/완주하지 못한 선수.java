import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
            Map<String, Integer> count = new HashMap<>();
    for (String p : participant) {
        count.put(p, count.getOrDefault(p, 0) + 1);
    }
    for (String c : completion) {
        count.put(c, count.get(c) - 1);
    }
    for (Map.Entry<String, Integer> e : count.entrySet()) {
        if (e.getValue() > 0) {
            return e.getKey();
        }
    }
    return ""; 
    }
}