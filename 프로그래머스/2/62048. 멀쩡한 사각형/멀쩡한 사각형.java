class Solution {
    public long solution(int w, int h) {
        
        long answer = (long)w*h - (w + h); // 전체 칸 수에서 세로 한 칸, 가로 한 칸 넘은 것들 사용 불가
        
        // 최대공약수 구하기
        long gcb = findGcb(Math.max(w,h), Math.min(w,h));
        answer += gcb;
        
        return answer; 
    }
    
    static long findGcb(int max, int min) {
        if (min == 0) {
            return max;
        }
        return(findGcb(min, max % min));
    }
    

}