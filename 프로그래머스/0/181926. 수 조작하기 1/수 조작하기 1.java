class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        char[] charControlArray = control.toCharArray();
        
        for (int i = 0; i < charControlArray.length; i++) {
            if (charControlArray[i]=='w') {
                answer++;
            } else if (charControlArray[i]=='s') {
                answer--;
            } else if (charControlArray[i]=='d') {
                answer+=10;
            } else {
                answer-=10;
            }
        }
        
        return answer;
    }
}