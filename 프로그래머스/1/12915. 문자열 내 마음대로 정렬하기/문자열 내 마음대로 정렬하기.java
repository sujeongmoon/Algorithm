import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        
        Arrays.sort(strings, (a, b) -> {
            return Character.compare(a.charAt(n), b.charAt(n));
            // Integer.compare썼던것처럼 Character로 wrapper해줘야함
            // 그리고 이렇게되면 compareTo가아니라 compare임
        });
        
        /*
        Arrays.sort(strings, (a, b) -> {

            return a.charAt(n).compareTo(b.charAt(n));

        });
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ?
                   o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
              
        return strings;
    }
}