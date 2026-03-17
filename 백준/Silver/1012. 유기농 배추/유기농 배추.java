import java.util.*;
import java.io.*;

public class Main {

	static int M;
	static int N;
	static int[][] FARM;
	static boolean[][] FARMVISITED;
	static int COUNT;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스 for문
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K =  Integer.parseInt(st.nextToken());

			FARM = new int[M][N];
			FARMVISITED = new boolean[M][N];
			COUNT = 0;

			// 배추밭 배열 만들기 완료
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				FARM[X][Y] = 1;
			}

			// 1인 경우 dfs
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (FARM[j][k] == 1 && !FARMVISITED[j][k]) {
						dfs(j, k);
						COUNT++;
					}
				}
			}

			bw.write(COUNT+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int r, int c) {
		// 범위 벗어나는 경우 return 0
		if (r < 0 ||  r >= M || c < 0 || c >= N) {
			return;
		}

		// 0을 방문하는 경우 return 0
		if (FARM[r][c] == 0) {
			return;
		}

		// 이미 방문한 경우 return 0
		if (FARMVISITED[r][c]) {
			return;
		}

		// 방문 처리 및 dfs
		FARMVISITED[r][c] = true;
		for (int i = 0; i < 4; i++) {
			dfs(r + dr[i], c + dc[i]);
		}
	}

}