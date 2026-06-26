import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // 1단계
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        
        // 2단계
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
            
        }
        
        // 4단계
        ArrayList<Integer> doubleList = new ArrayList<>(); // 중복되는 부분의 인덱스 저장 (자동으로 내림차순)
        
        // 끝부터 돌면서, 만약 뒤가 지금 자신과 같고, .이라면 doubleList에 저장
        for (int i = sb.length() - 2; i >= 0; i--) {
            if ((sb.charAt(i) == sb.charAt(i+1)) && sb.charAt(i) == '.') {
                doubleList.add(i);
            }
        }
        
        // 중복 제거
        for (int d : doubleList) {
            sb.deleteCharAt(d);
        }
        
                // 3단계 1 - 앞부분 제거
        while (sb.length() != 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        // 3단계 2 - 뒷부분 제거
        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.setLength(sb.length() - 1);
        }
        
        
        // 5단계
        if (sb.length() == 0) {
            sb.append('a');
        }
        
        // 6단계
        if (sb.length() >= 16) {
            sb.setLength(15);
        }
        
        // 6단계 2 - 뒷부분 .이면 제거
        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.setLength(sb.length() - 1);
        }
        
        // 7단계 
        if (sb.length() <= 2) {
            
            while (sb.length() != 3) {
                sb.append(sb.charAt(sb.length()-1));
            }
            
        }
        
        return sb.toString();
    }
}