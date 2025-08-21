class Solution {
    public String solution(String myString) {
        
        char[] charMyString = myString.toCharArray();
        StringBuilder answer = new StringBuilder();
        
        for (char c : charMyString){
            if (c < 'l') {
                answer.append('l');
            } else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}