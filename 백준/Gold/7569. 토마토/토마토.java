import java.util.*;
import java.io.*;

// 토마토의 위치를 저장할 클래스
class Tomato {
    int h, r, c;

    public Tomato(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int M, N, H;
    static int[][][] board;
    static Queue<Tomato> queue = new LinkedList<>();

    // 6방향 탐색 (위, 아래, 상, 하, 좌, 우)
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        board = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토라면 큐에 추가
                    if (board[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = t.h + dh[i];
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];

                // 범위를 벗어나지 않고, 익지 않은 토마토(0)인 경우만
                if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (board[nh][nr][nc] == 0) {
                        // 익게 만들고 날짜 갱신 (현재 값 + 1)
                        board[nh][nr][nc] = board[t.h][t.r][t.c] + 1;
                        queue.add(new Tomato(nh, nr, nc));
                    }
                }
            }
        }

        int maxDays = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 하나라도 익지 않은 게 남아있다면 -1
                    if (board[i][j][k] == 0) return -1;
                    maxDays = Math.max(maxDays, board[i][j][k]);
                }
            }
        }

        // 모든 토마토가 이미 익어있었다면 1-1=0, 그 외엔 최대 날짜 - 1
        return maxDays == 1 ? 0 : maxDays - 1;
    }
}