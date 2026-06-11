class Solution {
    
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1]; // begin부터 end까지의..
        
        // 이미 설치는 다 함
        
        for (int i = 0; i < answer.length; i++) {
            long nowIndex = begin + i;
            answer[i] = findNum(nowIndex);
        }
        
        return answer;
    }
    
    // 약수 찾기
    static int findNum(long nowIndex) {
        
        // 1이 들어온 경우
        if (nowIndex == 1) {
            return 0;
        }
        
        int maxBlock = 1;
        
        // 나눠지는 경우
        for (int i = 2; (i * i <= nowIndex); i++) {
            if (nowIndex % i == 0) {
                int n = (int)nowIndex/i;
                if (n > 10000000) {
                    maxBlock = i;
                    continue;
                }
                return n;
            }
        }
        
        // 나눠지지 않는 경우는 1 리턴
        return maxBlock;
    }
}