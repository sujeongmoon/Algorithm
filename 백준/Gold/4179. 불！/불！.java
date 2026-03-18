import java.util.*;
import java.io.*;

public class Main {

	static int M;
	static int N;
	static char[][] maze;
	static boolean[][] visited;
	// static int COUNT;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static ArrayDeque<Piece> queue = new ArrayDeque<>();

	static class Piece {
		char c;
		int count;
		int row;
		int col;

		public Piece(char c, int row, int col, int count) {
			this.c = c;
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[] jihoon = new int[2];
		maze = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				maze[i][j] = line.charAt(j);
				if (maze[i][j] == 'F') {
					queue.add(new Piece('F', i, j, 0));
				} else if (maze[i][j] == 'J') {
					jihoon[0] = i;
					jihoon[1] = j;
				}
			}
		}
		queue.add(new Piece('J', jihoon[0], jihoon[1], 0)); // J는 마지막에
		visited[jihoon[0]][jihoon[1]] = true;

		int answer = bfs();

		bw.write(answer !=-1? Integer.toString(answer) : "IMPOSSIBLE");
		bw.flush();
		bw.close();
		}


	static int bfs() {
		while (!queue.isEmpty()) {
			Piece p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nRow = p.row + dr[i];
				int nCol = p.col + dc[i];

				if (p.c == 'F') {
					if (nRow >= 0 && nRow < M && nCol >= 0 && nCol < N) {
						if (maze[nRow][nCol] == '.' || maze[nRow][nCol] == 'J') {
							maze[nRow][nCol] = 'F';
							queue.add(new Piece('F', nRow, nCol, p.count + 1));
						}
					}
				} else {
					// 2. 지훈이의 이동
					if (nRow < 0 || nRow >= M || nCol < 0 || nCol >= N) {
						return p.count + 1; // 범위 벗어나면 바로 리턴(탈출 성공)
					}

					if (maze[nRow][nCol] == '.' && !visited[nRow][nCol]) {
						visited[nRow][nCol] = true;
						queue.add(new Piece('J', nRow, nCol, p.count + 1));
					}
				}
			}
		}
		return -1;
	}
}
