import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        boolean[] isSpell = new boolean[spell.length];
        
        for (String d : dic) {
            Arrays.fill(isSpell, false);
            for (int i = 0; i < spell.length; i++) {
                char c = spell[i].charAt(0);
                for(int j = 0; j < d.length(); j++) {
                    if (d.charAt(j) == c) {
                        isSpell[i] = true;
                    }
                }
            }
            
            for (int i = 0; i < isSpell.length; i++) {
                if (isSpell[i] == false) {
                    break;
                }
                if (i == isSpell.length - 1) {
                    return 1;
                }
            }
            
        }
        
        return answer;
    }
}