

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static int arts = 0;
	static int maxSize = 0;
	static int size = 0;

	static void dfs(int[][] artArray, int i, int j) {

		if ((i == artArray.length) || (j == artArray[0].length) || (i == -1) || (j == -1)) {
			return;
		}
		if (artArray[i][j] == 0) {
			return;
		}
		if (visited[i][j] == true) {
			return;
		}

		// artArray[i][j]가 1이고 방문한 적 없는 노드
		visited[i][j] = true;
		size++;

		dfs(artArray, i + 1, j);
		dfs(artArray, i, j + 1);
		dfs(artArray, i - 1, j);
		dfs(artArray, i, j - 1);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] artArray = new int[n][m];
		visited = new boolean[n][m];

		// 이차원 배열 만들기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				artArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false && artArray[i][j] == 1) {
					dfs(artArray, i, j);
					if (size > maxSize) {
						maxSize = size;
					}
					arts++;
					size = 0;
				}
			}
		}

		bw.write(new StringBuilder().append(arts).append("\n").append(maxSize).append("\n").toString());

		bw.flush();
		bw.close();
	}
}


