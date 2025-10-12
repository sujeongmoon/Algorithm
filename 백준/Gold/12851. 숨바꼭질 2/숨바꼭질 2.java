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
		int visitWays[] = new int [100001];
		Arrays.fill(visitTime, -1);
		Arrays.fill(visitWays, 0);

		visitTime[N] = 0; // N 위치에 처음부터 위치해있으니까 0이다
		visitWays[N] = 1;

		//BFS 구현 위해 Queue-> 나는 ArrayDeque 써야겠다
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 첫 시작점을 큐에 넣어주기
		queue.add(N);

		int answerTime = -1;

		//BFS 탐색
		while(!queue.isEmpty()) {
			int now = queue.poll();

			if (answerTime != -1 && visitTime[now] > answerTime) {
				break;
			}

			int nextList[] = {now - 1, now + 1, now * 2}; // 다음으로 갈 수 있는 값들
			for (int next : nextList) {
				if (0 <= next && next <= 100000) {  // next가 범위 안에 있고 방문한 적 없는 노드일 경우
					if (visitTime[next] == -1) {
						visitTime[next] = visitTime[now] + 1;
						visitWays[next] = visitWays[now];
						queue.add(next); // bfs 큐에다가 방문한 노드 추가
					} else if (visitTime[next] == visitTime[now] + 1) {
						// 동일한 최단거리로 도달하는 추가 경로
						visitWays[next] += visitWays[now];
					}
				}
			}
			if (now == K) {
				answerTime = visitTime[now];
			}
		}

		System.out.println(visitTime[K]);
		System.out.println(visitWays[K]);

	}
}
