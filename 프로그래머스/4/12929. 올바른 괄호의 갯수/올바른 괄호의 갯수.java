class Solution {
    
    static int answer;
    
    public int solution(int n) {
        answer = 0;

        backtracking(0, 0, n);
        
        return answer;
    }
    
    public static void backtracking(int nowOpen, int nowIdx, int solN) {
        // 열린 괄호 갯수, 현재 인덱스, 현재 배열, 주어진 n
        
        // 종료조건
        if ((nowOpen == 0) && (nowIdx == (2 * solN))) {
            answer++;
            return;
        }
        
        if (nowIdx == (2 * solN)) {
            return;
        }
        
        // 괄호를 열 수 있는 경우
        if (nowOpen < solN) {
            backtracking(nowOpen+1, nowIdx+1, solN);
        }
        
        // 괄호를 닫을 수 있는 경우
        if (nowOpen != 0) {
            backtracking(nowOpen-1, nowIdx+1, solN);
        }
    }
}