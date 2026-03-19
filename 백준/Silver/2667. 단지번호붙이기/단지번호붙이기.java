import java.util.*;
import java.io.*;

public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int N;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];
		int danjiCount = 0;

		for (int i = 0; i < N; i++) {
			String st =  br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1'  && visited[i][j] == false) {
					list.add(bfs(i, j));
					danjiCount++;
				}
			}
		}

		bw.write(danjiCount+"\n");
		Collections.sort(list);

		for(int i = 0; i < danjiCount; i++) {
			bw.write(list.get(i)+"\n");
		}

		bw.flush();
		bw.close();

		}


	static int bfs(int row, int col) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[]{row, col});
		visited[row][col] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int[] cur =  queue.poll();

			for (int i = 0; i < 4; i++) {
				if ( cur[0] + dr[i] < 0 || cur[0] + dr[i] >= N || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= N ) {
					continue;
				}
				if ( map[cur[0] + dr[i]][cur[1] + dc[i]] == '0' || visited[cur[0] + dr[i]][cur[1] + dc[i]] == true) {
					continue;
				}

				queue.add(new int[]{cur[0] + dr[i], cur[1] + dc[i]});
				visited[cur[0] + dr[i]][cur[1] + dc[i]] = true;
				count++;
			}
		}

		return count;

	}
}
