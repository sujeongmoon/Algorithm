class Solution {
    
    private static int N;
    private static boolean[] width;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;
    
    private static int getAns(int y) { //퀸이 서로 공격할 수 없는 위치에 놓이는 경우의 수를 구하는 함수
        int ans = 0;
        
        if (y  == N) { // 모든 행에 대해서 퀸의 위치가 결정된 경우 -> 퀸이 n개만큼 채워진 경우
            ans++; //정답 ++
        } else {
            
            for (int i = 0; i < N; i++) { // "현재 행"에서 퀸이 놓일 수 있는 모든 위치를 시도
                if (width[i] || diagonal1[i+y] || diagonal2[i-y+N])
                    continue; // 해당 위치에 이미 퀸이 있거나, 대각선상에 퀸이 있다면 스킵
                
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true; // 없으면 자리가 있다는 뜻, 퀸을 놓음
                ans += getAns(y+1); // 다음 행으로 이동해서 재귀적으로 해결 가능한 경우의 수를 찾음
                width[i] = diagonal1[i+y] = diagonal2[i - y + N] = false; // 이후 해당 위치에 놓인 퀸 제거
                // 나는 기존 퀸의 범위를 다 배열에 넣어두려고 했는데, 그냥 퀸을 새로 놓을 때 해당 대각선 위치에 퀸ㅇ의 여부를 체크하면 됨!
            }
            
        }
        return ans;
        
    }
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        int answer = getAns(0); // 열 당 퀸 하나가 무조건 수반돼야하니까. 열 기준으로 넣기
        return answer;
    }
} 