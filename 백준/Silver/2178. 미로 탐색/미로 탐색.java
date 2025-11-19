import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
	private static final int[] rx = {0, 0, 1, -1};
	private static final int[] ry = {1, -1, 0, 0};

	private static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		int[][] distance = new int[N][M];
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}

		queue.offer(new Node(0, 0));
		distance[0][0] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			// 현재 이동할 수 있는 모든 방향
			for (int i = 0; i < 4; i++) {
				int nr = now.r + rx[i];
				int nc = now.c + ry[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				if (maze[nr][nc] == 0) {
					continue;
				}

				if (distance[nr][nc] == 0) {
					queue.offer(new Node(nr, nc));
					distance[nr][nc] = distance[now.r][now.c] + 1;
				}
			}
		}
		bw.write(String.valueOf(distance[N - 1][M - 1]));
		bw.flush();
		bw.close();
	}
}
