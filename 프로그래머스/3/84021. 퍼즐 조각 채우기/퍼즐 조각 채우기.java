import java.util.*;

class Solution {
    
    // public static boolean[][] isVisitedGameBoard;
    // public static boolean[][] isVisitedTable;
    
    public static int[] dr = new int[] {1, -1, 0, 0};
    public static int[] dc = new int[] {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        boolean[][] isVisitedGameBoard = new boolean[game_board.length][game_board[0].length]; // 방문여부 체크
        boolean[][] isVisitedTable = new boolean[table.length][table[0].length];
        
        ArrayList<ArrayList<int[]>> boardList = new ArrayList<>();
        ArrayList<ArrayList<int[]>> tableList = new ArrayList<>();
        
        
        // dfs로 game_board의 빈 공간을 찾는다
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 0 && !isVisitedGameBoard[i][j]) {
                    ArrayList<int[]> emptyPiece = new ArrayList<>();
                    dfs(i, j, game_board, emptyPiece, isVisitedGameBoard, 1);
                    
                    // emptyPiece서 최소값 찾기
                    int minI = Integer.MAX_VALUE;
                    int minJ = Integer.MAX_VALUE;
                    for (int[] ep : emptyPiece) {
                        minI = Math.min(ep[0], minI);
                        minJ = Math.min(ep[1], minJ);
                    }
                    
                    // 최소값만큼 빼기
                    for (int[] ep : emptyPiece) {
                        ep[0] -= minI;
                        ep[1] -= minJ;
                    }
                    
                    // 기준점 정렬( 기준값 빼기)
                    Collections.sort(emptyPiece, (o1, o2) -> {
                        // 위, 왼쪽 기준으로 정렬
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    });
                    
                    boardList.add(emptyPiece);
                }   
            }
        }
        
        // dfs로 테이블의 빈 공간을 찾고, 비교한다
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                
                if (table[i][j] == 1 && !isVisitedTable[i][j]) {
                    ArrayList<int[]> tablePiece = new ArrayList<>();
                    dfs(i, j, table, tablePiece, isVisitedTable, 0);
                    
                    // piece서 최소값 찾기
                    int minI = Integer.MAX_VALUE;
                    int minJ = Integer.MAX_VALUE;
                    for (int[] p : tablePiece) {
                        minI = Math.min(p[0], minI);
                        minJ = Math.min(p[1], minJ);
                    }
                    
                    // 최소값만큼 빼기
                    for (int[] p : tablePiece) {
                        p[0] -= minI;
                        p[1] -= minJ;
                    }
                    
                    // 기준점 정렬( 기준값 빼기)
                    Collections.sort(tablePiece, (o1, o2) -> {
                        // 위, 왼쪽 기준으로 정렬
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    });
                    
                    tableList.add(tablePiece);
                }   
                
            }
        }
        
        // 퍼즐 조각 사용 여부를 기록할 배열 (tableList 크기만큼)
        boolean[] isTablePieceUsed = new boolean[tableList.size()];

        // 비교
        for (int i = 0; i < boardList.size(); i++) {
            ArrayList<int[]> boardPiece = boardList.get(i);

            for (int j = 0; j < tableList.size(); j++) {
                // 이미 다른 곳에 사용한 조각이면 패스
                if (isTablePieceUsed[j]) {
                    continue;
                }

                ArrayList<int[]> tablePiece = tableList.get(j);

                // 두 조각 칸 수 다르면 패스
                if (boardPiece.size() != tablePiece.size()) {
                    continue;
                }

                boolean isMatch = false;
                
                for (int k = 0; k < 4; k++) {
                    if (isSamePiece(boardPiece, tablePiece)) {
                        isMatch = true;
                        break; // rotation 탈출
                    }
                    tablePiece = rotatePiece(tablePiece, table.length);
                }

                if (isMatch) {
                    answer += boardPiece.size();
                    isTablePieceUsed[j] = true;
                    break; // j for문 탈출
                }
            }
        }
        
        
        
        return answer;
    }
    
    // 각각 내용이 일치하는지 확인
    public static boolean isSamePiece(ArrayList<int[]> bp, ArrayList<int[]> tp) {
        // 둘의 칸 수는 동일한 상황
        for (int i = 0; i < bp.size(); i++) {
            if (bp.get(i)[0] != tp.get(i)[0] || bp.get(i)[1] != tp.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
    
    // 안의 좌표들을 90도 돌리기
    public static ArrayList<int[]> rotatePiece(ArrayList<int[]> tp, int length) {
        
        ArrayList<int[]> rotateList = new ArrayList<>();
        for (int[] t : tp) {
            int r = t[0];
            int c = t[1];
            
            // 90도 전환한 값
            int nextR = c;
            int nextC = (length - 1) - r;
            rotateList.add(new int[] {nextR, nextC});
        }
        
        // 다시 0,0 기준 정하기
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for (int[] r : rotateList) {
            minR = Math.min(r[0], minR);
            minC = Math.min(r[1], minC);
        }
        
        // 0,0 기준으로 좌표 바꾸기
        for (int[] r : rotateList) {
            r[0] -= minR;
            r[1] -= minC;
        }
        
        // 다시 정렬
        Collections.sort(rotateList, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        
        // 리턴
        return rotateList;
    }
    
    
    
    public static void dfs(int  i, int j, int[][] board, ArrayList<int[]> list, boolean[][] isVisited, int checkNum) {
        
        // 범위를 벗어나면 종료
        if (i == board.length || j == board[0].length || i == -1 || j == -1) {
            return;
        }
        
        // 이미 방문했으면 종료 //////////////////
        if (board[i][j] == checkNum || isVisited[i][j]) {
            return;
        }
        
        // 방문처리 및 좌표 추가
        isVisited[i][j] = true;
        list.add(new int[] {i, j});
        
        for (int k = 0; k < 4; k++) {
            int nextI = i + dr[k];
            int nextJ = j + dc[k];
            dfs(nextI, nextJ, board, list, isVisited, checkNum);
        }
        
    }
}