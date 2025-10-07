class Solution {
    public int solution(int n) {
        int num1 = 0;
        int answer = 1;
        int count = 1;
        
        while (count < n) {
            int num = num1;
            num1 = answer;
            answer = (num + num1) % 1234567;
            count++;
        }
        
        return answer;
    }
}