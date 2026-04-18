class Solution {
    public static boolean[] arr;
    public static int answer;
    public static int m;
    public static int[][] qStatic;
    public static int nStatic;
    public static int[] ansStatic;
    
    public int solution(int n, int[][] q, int[] ans) { // q의 범위, 입력한 정수를 담은 2차원 정수 배열, 시스템 응답을 담은 정수 배열
        answer = 0;
        arr = new boolean[n+1];
        m = q.length;
        nStatic = n;
        ansStatic = ans;
        qStatic = q;
        
        backtracking(1, 0);

        return answer;
    }
    
    
    public static void backtracking(int idx, int count) {
        
        if (count == 5) {
            // 전체값 돌리기
            
            for (int i = 0; i < m; i++) {
                //q[i]와 ans가 몇 개 겹치는지 확인
                int c = 0;
                for (int j = 0; j < 5; j++) {
                    if (arr[qStatic[i][j]]) {
                        c++;
                    }
                }
                if (c != ansStatic[i]) {
                    return;
                }
            }
            // 조건 종료
            answer++;
            return; 
                     
        }
        for(int i = idx; i <= nStatic; i++) {
            arr[i] = true;
            backtracking(i+1, count+1);
            arr[i] = false;
        }
    }   
    
}