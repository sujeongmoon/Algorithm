

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	// 상, 하, 좌, 우 이동을 위한 배열
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] box;
	static int M, N;
	static Queue<int[]> queue = new LinkedList<>();


	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// String s = br.readLine();

		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		box = new int[N][M];

		for (int i = 0; i < N; i++) { // row 먼저인데, 이건 세로 길이임
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) { // col, 가로 길이임
				box[i][j] = Integer.parseInt(st.nextToken());
				// 1. 핵심: 시작할 때 익은 토마토(1)를 모두 큐에 넣는다! -> 1을 발견하면 해당 좌표를 {r,c} 배열로 큐에 넣음
					// => 이건 r,c 값 두 개만 필요하니까 따로 클래스를 만들진 않아도 됨
				if (box[i][j] == 1) {
					queue.add(new int[]{i, j}); // 그러면 초기값들이 다 전역queue에 들어간 상황.
				}
			}
		}
		System.out.println(bfs()); // 일단 bfs 호출하기. (일단은 초기값들만 전역queue에 있는 상태임)
	}
	static int bfs() {
		while (!queue.isEmpty()) { // 큐가 빌 때까지 돈다
			int[] now = queue.poll(); // bfs 는, 큐에 들어갈떄 방문처리되는거지?
			int x = now[0]; // row(세로길이)
			int y = now[1]; // col(가로길이)

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 네 방향을 돌면서! 범위를 벗어나지 않고, 아직 안 익은 토마토(0)라면
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (box[nx][ny] == 0) {
						// 2. 핵심: 익음 처리하고 날짜(현재값 + 1)를 적는다
						box[nx][ny] = box[x][y] + 1;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		// 3. 결과 확인
		int maxDays = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) return -1; // 안 익은 게 남았다면 실패
				maxDays = Math.max(maxDays, box[i][j]); // 배열 값 중 가장 최대값 -> 가장 나중에 익은 토마토
			}
		}

		// 처음 익은 토마토가 1이었으므로 1을 빼줘야 실제 걸린 일수임
		return (maxDays == 0) ? 0 : maxDays - 1;
	}
}
