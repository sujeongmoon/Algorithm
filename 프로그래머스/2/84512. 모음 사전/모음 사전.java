import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
    
        dfs(""); // 리스트 채우기
        
        answer = list.indexOf(word);
        
        
        
        return answer + 1;
    }
    
    void dfs(String str) {
        
        if (str.length() > 5) {
            return;
        }
        
        // 빈 문자열이 아니라면 추가
        if (str.length() != 0) {
            list.add(str);
        }
        
        // dfs 반복
        for (int i = 0; i < 5; i++) {
            dfs(str + arr[i]);
        }
        
    }
}