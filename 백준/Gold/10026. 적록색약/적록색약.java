

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
	static char[][] paint1;
	static char[][] paint2;

	static boolean[][] visited1;
	static boolean[][] visited2;

	static Queue<Character> queue = new LinkedList<>();

	// 6방향 탐색 (상, 하, 좌, 우)
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		paint1 = new char[N][N];
		paint2 = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				paint1[i][j] = line.charAt(j);
				// 적록색약용: R과 G를 똑같이 취급 (보통 R로 통일)
				paint2[i][j] = (paint1[i][j] == 'G') ? 'R' : paint1[i][j];
			}
		}

		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					dfs(i, j, paint1[i][j], paint1, visited1);
					count1++; // DFS 한 세트가 끝나면 영역 +1
				}
				if (!visited2[i][j]) {
					dfs(i, j, paint2[i][j], paint2, visited2);
					count2++; // DFS 한 세트가 끝나면 영역 +1
				}
			}
		}


		System.out.println(count1 + " " + count2);
	}

	static void dfs(int r, int c, char color, char[][] paint, boolean[][] visited) {
		// 1. 범위를 벗어나거나, 이미 방문했거나, 색깔이 다르면 컷!
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return;
		}
		if (visited[r][c] || paint[r][c] != color) {
			return;
		}

		// 2. 방문 처리
		visited[r][c] = true;

		// 3. 4방향으로 계속 파고들기
		for (int i = 0; i < 4; i++) {
			dfs(r + dr[i], c + dc[i], color, paint, visited);
		}
	}


}
