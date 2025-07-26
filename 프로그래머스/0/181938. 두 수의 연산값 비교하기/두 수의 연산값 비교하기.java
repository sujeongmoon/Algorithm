class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String stringPlus = Integer.toString(a) + Integer.toString(b);
        int stringPlusToInt = Integer.parseInt(stringPlus);
        int twoAB = 2 * a * b;
        
        if (stringPlusToInt < twoAB) {
            answer = twoAB;
        } else {
            answer = stringPlusToInt;
        }
    
        return answer;
    }
}