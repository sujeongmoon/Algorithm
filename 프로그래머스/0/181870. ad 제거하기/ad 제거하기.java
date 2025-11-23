import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> answerList = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")){
                answerList.add(str);
            }
            
        }
        return answerList.toArray(new String[answerList.size()]);
    }
        
}