class Solution {
    
    static int[] dr = {1, 0, 1};
    static int[] dc = {0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 탐색으로
        
        // 1. 각 라운드마다, 돌아가면서 네모가 있는지 찾는다.
            // roudflag는 false처리
            // 'x'인 경우는 그냥 넘김
            // 네모를 발견하면 해당은 빠지는 거라고 표시한다. & roundflag에 true로 표시한다(터졌나안터졌냐 판별)
        
        // 2. 만약 끝까지 roundflag가 false였다면 while문 종료
        
        char[][] boardArr = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardArr[i][j] = board[i].charAt(j);
            }
        }
        
        boolean roundFlag = true; // 한번이라도 터졌는지 여부
        boolean[][] isPopped = new boolean[m][n];
        
        while (roundFlag) {
            
            roundFlag = false;
            isPopped = new boolean[m][n]; // pop여부배열 초기화
            
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    
                    
                    char nowC = boardArr[i][j];
                    
                    // X인경우는 넘김
                    if (nowC == 'X') {
                        continue;
                    }
                    
                    boolean flag = false;
                    // 돌아가면서 같은지 체크, 네모가 아닌 걸 발견할 시 그냥 바로 넘어간다
                    for (int k = 0; k < 3; k++) {
                        if (boardArr[i+dr[k]][j+dc[k]] != nowC) {
                            flag = true;
                            break;
                        }
                    }
                    
                    // 네모가 아닌 경우에는 스킵
                    if (flag) {
                        continue;
                    }
                    
                    // 네모인 경우에는 처리해주기
                    isPopped[i][j] = true;
                    roundFlag = true;
                    for (int k = 0; k < 3; k++) {
                        isPopped[i+dr[k]][j+dc[k]] = true;
                        System.out.println("dsdfs");
                    }
                    
                }
            }
            
            // 라운드 탐색이 끝났다
            if (!roundFlag) {
                break;
            }
            
            // answer count
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isPopped[i][j]) {
                        boardArr[i][j] = 'X'; // 터지는 블록을 X로 바꿔줌
                        answer++; 
                    }
                }
            }
            
            // x 처리
            
            for (int c = 0; c < n; c++) {
                int writeIdx = m - 1; // boardArr 인덱스
                
                for (int r = m - 1; r >= 0; r--) {
                    // 진짜 블록을 발견하면
                    if (boardArr[r][c] != 'X') {
                        char temp = boardArr[r][c];
                        boardArr[r][c] = 'X'; // 원래 자리는 비우고
                        boardArr[writeIdx][c] = temp; // 차곡차곡 쌓기
                        writeIdx--; // 다음 쌓을 칸은 한 칸 위로
                    }
                }
            }
        }
              
        return answer;
    }
}