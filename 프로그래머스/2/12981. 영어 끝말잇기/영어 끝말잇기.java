import java.util.*;

class Solution {
    
    public int[] buildAnswer(int i, int n) {
        int nodeNumber = i % n + 1;
        int nodeTurn = i / n + 1;
        
        return new int[] {nodeNumber, nodeTurn};
    }
    
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        HashSet<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        String latestWord = words[0];
        
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) !=
               latestWord.charAt(latestWord.length() - 1)) {
                return buildAnswer(i, n);
            }
            
            if (usedWords.contains(words[i])) {
                return buildAnswer(i,n);
            }
            
            usedWords.add(words[i]);
            latestWord = words[i];
        }
        
        
        
        

        return answer;
    }
}