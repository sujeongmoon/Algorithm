import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>(); // 카테고리 , 수
        ArrayList<String> list = new ArrayList<>(); // 카테고리 이름 담은 arrayList
        for (int i = 0; i < clothes.length; i++) {
            
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for (int count : map.values()) {
            answer *= (count+1); // count+1 -> 안 입는 경우
        }
        
        
        return answer - 1; // 모두 다 안 입는 경우는 빼준다
    }
}