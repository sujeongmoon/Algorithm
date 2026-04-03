import java.util.*;
import java.io.*;

public class Main {

	static int[][] changedMap;
	static boolean[][] isVisited;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		ArrayList<int[]> zeroList = new ArrayList<>();
		int max = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int space = Integer.parseInt(st.nextToken());
				map[i][j] = space;
				if (space == 0) {
					zeroList.add(new int[] {i, j});
				}
			}
		}

		int[][] zeroArr = zeroList.toArray(new int[0][0]);

		for (int i = 0; i < zeroArr.length; i++) {
			for (int j = i+1; j < zeroArr.length; j++) {
				for (int k = j+1; k < zeroArr.length; k++) {
					changedMap = new int[N][M];
					isVisited = new boolean[N][M];
					for (int l = 0; l < N; l++) {
						changedMap[l] = map[l].clone();
					}
					changedMap[zeroArr[i][0]][zeroArr[i][1]] = 1;
					changedMap[zeroArr[j][0]][zeroArr[j][1]] = 1;
					changedMap[zeroArr[k][0]][zeroArr[k][1]] = 1;

					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							if (changedMap[n][m] == 2 && !isVisited[n][m]) {
								bfs(n, m);
							}
						}
					}

					int nowZero = 0;

					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							if (changedMap[n][m] == 0) {
								nowZero++;
							}
						}
					}
					max = Math.max(max, nowZero);

				}
			}
		}

		bw.write(max+"");
		bw.flush();
		bw.close();

	}

	public static void bfs(int r, int c) {


		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		isVisited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int curR =  curr[0];
			int curC =  curr[1];

			for (int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];

				if (nextR < 0 || nextR >= changedMap.length || nextC < 0 || nextC >= changedMap[nextR].length) {
					continue;
				}
				if (isVisited[nextR][nextC] || changedMap[nextR][nextC] != 0) {
					continue;
				}

				isVisited[nextR][nextC] = true;
				changedMap[nextR][nextC] = 2;

				queue.offer(new int[] {nextR, nextC});
			}
		}
	}
}

