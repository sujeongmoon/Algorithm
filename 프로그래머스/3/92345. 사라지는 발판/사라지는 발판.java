import java.util.*;

class Solution {
    
    private static class Result {
        boolean win;
        int step;
        
        public Result(boolean win, int step) {
            this.win = win;
            this.step = step;
        }
    }
        
    static int[] rx = {1, -1, 0, 0};
    static int[] ry = {0, 0, 1, -1};
    
    static int ROW;
    static int COL;
    static int[][] BOARD;
    static boolean[][] visited;
    
    static boolean isValidToGo(int x, int y) {
        return 0 <= x && x < ROW && 0 <= y && y < COL;
    }
    

    
    static Result recursive (int[] aloc, int[] bloc, int step) {
        // a좌표입력, b좌표입력, 지금까지 총 몇 번째인지 입력
        
        // 현재 움직여야하는 배열이 무엇인지
        int[] now = step % 2 == 0 ? aloc : bloc;
        boolean canMove = false;
        boolean isOpponentWinner = true;
        
        ArrayList<Integer> winSteps = new ArrayList<>();
        ArrayList<Integer> loseSteps = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            int nx = now[0] + rx[i];
            int ny = now[1] + ry[i];
            
            if (isValidToGo(nx, ny) && !visited[nx][ny] && BOARD[nx][ny] == 1) {
                canMove = true;
                
                // 두 플레이어의 위치가 같으면 a가 이긴것이므로 true랑 step+1 반환
                if (aloc[0] == bloc[0] && aloc[1] == bloc[1]) {
                    return new Result(true, step + 1);
                }
                
                visited[now[0]][now[1]] = true; // 방문 체크
                Result result = step % 2 == 0? recursive(new int[]{nx, ny}, bloc, step + 1) : recursive(aloc, new int[]{nx, ny}, step + 1);
                visited[now[0]][now[1]] = false; // 백트레킹 이후 원복
                
                isOpponentWinner &= result.win; // 상대플레이어가 이기면 true로 유지
                
                if (result.win) 
                    winSteps.add(result.step);
                else
                    loseSteps.add(result.step);
            }
        }
        
        if (!canMove) // 이동 못하는 경우
            return new Result(false, step);
        if (isOpponentWinner) // 상대가 이긴 경우
            return new Result(false, winSteps.stream().max(Comparator.comparingInt(o -> o)).get());
        // 현재 플레이어가 이긴 경우
        return new Result(true, loseSteps.stream().min(Comparator.comparingInt(o -> o)).get());

    }
    
    
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        ROW = board.length;
        COL = board[0].length;
        BOARD = board;
        visited = new boolean[ROW][COL];
        
        return recursive(aloc, bloc, 0).step;

    }
}