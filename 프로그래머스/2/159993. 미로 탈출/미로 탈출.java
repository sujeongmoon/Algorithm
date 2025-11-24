import java.util.*;

class Solution {

	static int[] rx = {1, -1, 0, 0};
	static int[] ry = {0, 0, 1, -1};
	static boolean[][] visited;
	static char[][] maze;
	static int row;
	static int col;

	static ArrayDeque<int[]> queue = new ArrayDeque<>();

	static int bfs(int sx, int sy, char target) {

		boolean[][] visited = new boolean[row][col]; // visited는 각각 함수마다 따로 분리
		ArrayDeque<int[]> queue = new ArrayDeque<>(); // queue도 각각 함수마다 따로 분리

		queue.offer(new int[] {sx, sy, 0});
		visited[sx][sy] = true;

		while (!queue.isEmpty()) {
			int [] now = queue.poll();
			int x =  now[0];
			int y = now[1];
			int d = now[2];

			if (maze[x][y] == target) {
				return d;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + rx[i];
				int ny = y + ry[i];

				if (nx < 0 || nx >= row || ny < 0 || ny >=col) continue;
				if (maze[nx][ny] == 'X') continue;
				if (visited[nx][ny]) continue;

				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny, d + 1});
			}
		}

		return -1;
	}

	public int solution(String[] maps) {
		//answer = 0;

		row = maps.length;
		col = maps[0].length();

		maze = new char[row][col];

		int sx = 0;
		int sy = 0;
		int lx = 0;
		int ly = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				maze[i][j] = maps[i].charAt(j);
				if (maze[i][j] == 'S') {
					sx = i;
					sy = j;
				}

				if (maze[i][j] == 'L') {
					lx = i;
					ly = j;
				}
			}
		}

		int ld = bfs(sx, sy, 'L');
		if (ld == -1) return -1;
		int ed = bfs(lx, ly, 'E');
		if (ed == -1) return -1;

		return ld + ed;
	}
}