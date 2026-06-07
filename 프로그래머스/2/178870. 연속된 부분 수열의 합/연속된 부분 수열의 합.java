class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length - 1;
        int sum = 0;
    
        // -> 투포인터!
        int end = sequence.length-1; // 가장 끝 인덱스
        int start = sequence.length-1; // 가장 처음 인덱스
        
        
        for (int i = sequence.length-1; i >= 0; i--) {
            
            sum += sequence[i];
            start = i;
            
            // 만약에 모두 더한 값이 k보다 크면, 큰 값을 빼고 포인터를 앞으로 옮긴다.
            if (sum == k) {
                if ((answer[1] - answer[0]) < (end - start)) {
                    continue;
                }
                answer[0] = start;
                answer[1] = end;
                
                sum -= sequence[end];
                end--;
    
            } else if (sum > k) {
                sum -= sequence[end];
                end--;
            }
        }
        
        return answer;
    }
}