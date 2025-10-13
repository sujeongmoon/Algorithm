import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int visitTime[] = new int[100001]; // 방문한 배열 ,,  현재 방문할 때까지 걸린 시간?
		Arrays.fill(visitTime, -1);

		visitTime[N] = 0; // N 위치에 처음부터 위치해있으니까 0이다

		//BFS 구현 위해 Queue-> 나는 ArrayDeque 써야겠다
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 첫 시작점을 큐에 넣어주기
		queue.add(N);

		//BFS 탐색
		while(!queue.isEmpty()) {
			int now = queue.poll();

			if (now == K) {
				System.out.println(visitTime[K]);
				break;
			}

			int nextList[] = {now * 2, now - 1, now + 1}; // 다음으로 갈 수 있는 값들
			for (int i = 0; i < nextList.length; i++) {
				if (0 <= nextList[i] && nextList[i] <= 100000) {
					if (visitTime[nextList[i]] == -1) { // next가 범위 안에 있고 방문한 적 없는 노드일 경우
						if (i == 0) {
							visitTime[nextList[i]] = visitTime[now];
						} else {
							visitTime[nextList[i]] = visitTime[now] + 1;
						}
						queue.add(nextList[i]); // bfs 큐에다가 방문한 노드 추가
					}
				}
			}
		}
	}
}