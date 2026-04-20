import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            
            if (choices[i] == 4) {
                continue;
            } else if (choices[i] == 1) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 3);
                System.out.println(survey[i].charAt(0));
            } else if (choices[i] == 2) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 2);
            } else if (choices[i] == 3) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 1);
            } else if (choices[i] == 5) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+ 1);
            } else if (choices[i] == 6) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 2);
            } else if (choices[i] == 7) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 3);
            }
        }
                        
        if (Math.max(map.get('R'), map.get('T')) == map.get('R')) {
            answer += 'R';
        
        } else if (Math.max(map.get('R'), map.get('T')) == map.get('T')) {
            answer += 'T';
        } else {
            answer += 'R';
        } 
                        
        if (map.get('C') > map.get('F')) {
            answer += 'C';
        } else if (map.get('F') > map.get('C')) {
            answer += 'F';
        } else {
            answer += 'C';
        }
        
        if (map.get('J') > map.get('M')) {
            answer += 'J';
        } else if (map.get('M') > map.get('J')) {
            answer += 'M';
        } else {
            answer += 'J';
        }
        
        if (map.get('A') > map.get('N')) {
            answer += 'A';
        } else if (map.get('N') > map.get('A')) {
            answer += 'N';
        } else {
            answer += 'A';
        }
                        
                        
                    
        return answer;
    }
}