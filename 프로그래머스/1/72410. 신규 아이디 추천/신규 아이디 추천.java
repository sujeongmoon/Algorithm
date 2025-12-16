import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb1 = new StringBuilder();
        
        new_id = new_id.toLowerCase();
        
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
        
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb1.append(c);
            }
        }
        
        boolean isDot = false;
        StringBuilder sb2 = new StringBuilder();
        
        for (int i = 0; i < sb1.length(); i++) {
            char c = sb1.charAt(i);
            
            if (c == '.') {
                if (isDot) {
                    continue;
                }
                isDot = true;
            } else {
                isDot = false;
            }
            sb2.append(c);
        }
        
        if (sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        } 
        
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length()-1);
        }
        
        if (sb2.length() == 0) {
            sb2.append('a');
        }
        
        if (sb2.length() >= 15) {
            sb2.setLength(15);
             if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
                sb2.deleteCharAt(sb2.length()-1);
            }
        }
        
        
        if (sb2.length() <= 2) {
            char c = sb2.charAt(sb2.length()-1);
            System.out.println(c);
            while (sb2.length() <= 2) {
                sb2.append(c);
            }
        }
        
        
        return sb2.toString();
    }
}