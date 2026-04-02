import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N;
	static int M;
	static int[][] rooms;
	static boolean[][] isVisited;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rooms = new int[N][M];
		isVisited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				rooms[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(r, c, d);

		bw.write(answer + "");
		bw.flush();
		bw.close();
	}

	public static void dfs(int r, int c, int d) {

		if (r < 0 || r >= N || c < 0 || c >= M) {
			return;
		}
		if (rooms[r][c] == 1) {
			return;
		}

		if (!isVisited[r][c]) {
			isVisited[r][c] = true;
			answer++;
		}

		// boolean isCleaned = false;

		for (int i = 0; i < 4; i++) {
			if ((d - 1) < 0) {
				d = 3;
			} else {
				d--;
			}

			if (r + dr[d] < 0 || r + dr[d] >= N || c+ dc[d] < 0 || c + dc[d] >= M) {
				continue;
			}
			if (!isVisited[r + dr[d]][c + dc[d]] && rooms[r + dr[d]][c + dc[d]] == 0) {
				dfs(r + dr[d], c + dc[d], d);
				return;
			}
		}
		// 리턴되지 않은 경우 -> 청소되지 않은 빈 칸이 없다
		int newd = d - 2;
		if (newd < 0) {
			newd += 4;
		}

		if (r + dr[newd] < 0 || r + dr[newd] >= N || c + dc[newd] < 0 || c + dc[newd] >= M) {
			return;
		}

		if (rooms[r + dr[newd]][c + dc[newd]] == 1) {
			return;
		}
		dfs(r + dr[newd], c + dc[newd], d);
		return;
	}
}
