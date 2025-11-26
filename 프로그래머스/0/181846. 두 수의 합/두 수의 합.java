import java.math.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        
        BigInteger bigNumber = new BigInteger(a);
        BigInteger bigNumberB = new BigInteger(b);
        
        answer = (bigNumber.add(bigNumberB)).toString();
        
        return answer;
    }
}