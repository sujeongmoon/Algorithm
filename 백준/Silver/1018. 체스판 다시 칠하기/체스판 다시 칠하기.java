import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static char[][] board;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int  i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++){
				board[i][j] = row.charAt(j);
			}
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int bfsAns = bfs(i,j);
				if (min > bfsAns) {
					min = bfsAns;
				}
			}
		}

		bw.write(min+"");
		bw.flush();
		bw.close();
	}

	public static int bfs(int startR, int startC) {

		boolean[][] isVisited = new boolean[8][8];

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});

		int nowR = 0;
		int nowC = 0;
		int answer = 0;

		isVisited[0][0] = true;


		while(!queue.isEmpty()) {

			// startX에 nowX를 더하기. 만약 nowX<0, nowX>=8이면 패스, isVisited면 패스
			// nowX가 홀수인 경우, board[startX+nowX]가 board[startX]랑 같으면 +1
			// 짝인경우, 다르면 +1

			int[] now = queue.poll();
			nowR = now[0];
			nowC = now[1];

			int boardR = startR + nowR;
			int boardC = startC + nowC;

			if ((nowR %2 == 0 &&  nowC %2 == 0) || (nowR %2 == 1 && nowC %2 == 1)) {
				if (board[startR][startC] != board[boardR][boardC]) {
					answer++;
				}
			} else {
				if (board[startR][startC] == board[boardR][boardC]) {
					answer++;
				}
			}

			for (int i = 0; i < 4; i++) {

				int nextR = nowR+dr[i];
				int nextC = nowC+dc[i];

				if (nextR < 0 || nextR >= 8 || nextC < 0 || nextC >= 8) {
					continue;
				}
				if (isVisited[nextR][nextC]) {
					continue;
				}

				queue.offer(new int[] {nextR, nextC});
				isVisited[nextR][nextC] = true;
            }

		}

		//리턴은 min(answer, 64-answer)
		return Math.min(answer, 64-answer);
	}
}
