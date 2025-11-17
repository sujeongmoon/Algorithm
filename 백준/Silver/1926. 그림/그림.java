

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
		if (visited[i][j] == false) {
			visited[i][j] = true;
			if (artArray[i][j] == 1) {
				if (i + 1 < artArray.length) {
					dfs(artArray, i + 1, j);
				}
				if (j + 1 < artArray[0].length) {
					dfs(artArray, i, j + 1);
				}
				if (i - 1 >= 0) {
					dfs(artArray, i - 1, j);
				}
				if (j - 1 >= 0) {
					dfs(artArray, i, j - 1);
				}
				size++;
			}
		}

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
				dfs(artArray, i, j);
				if (size > maxSize) {
					maxSize = size;
				}
				if (size > 0) {
					arts++;
				}
				size = 0;
			}
		}

		bw.write(new StringBuilder().append(arts).append("\n").append(maxSize).append("\n").toString());

		bw.flush();
		bw.close();
	}
}


