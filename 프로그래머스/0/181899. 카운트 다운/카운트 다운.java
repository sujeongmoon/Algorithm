class Solution {
    public int[] solution(int start_num, int end_num) {
        // int[] answer = {};
        int length = start_num - end_num + 1;
        int[] answer = new int[length];
        int num = start_num;
        
        for (int i = 0; i < length; i++) {
            answer[i] = num;
            num--;
        }
        
        return answer;
    }
}