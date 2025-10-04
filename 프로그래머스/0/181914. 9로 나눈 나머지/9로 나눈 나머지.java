class Solution {
    public int solution(String number) {
        int answer = 0;
        
        char[] numberChar = number.toCharArray();
        int sum = 0;
        
        for (char num : numberChar) {
            sum += num - '0';
        }
        
        answer = sum % 9;
        
        return answer;
    }
}