import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int visit[] = new int[100001]; // 방문한 배열 ,,  현재 방문할 때까지 걸린 시간?
		////// visit배열이 가지고있는 값 => i 위치에 몇 초만에 방문했나요?

		visit[N] = 0; // N 위치에 처음부터 위치해있으니까 0이다

		//BFS 구현 위해 Queue-> 나는 ArrayDeque 써야겠다
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 첫 시작점을 큐에 넣어주기
		queue.add(N);

		//BFS 탐색
		while(!queue.isEmpty()){
			int now = queue.poll();
			if (now == K) {
				System.out.println(visit[now]);
				break;
			}

			int nextList[] = {now - 1, now + 1, now * 2}; // 다음으로 갈 수 있는 값들
			for (int next: nextList) {
				if (0 <= next && next <= 100000 && visit[next] == 0) {  // next가 범위 안에 있고 방문한 적 없는 노드일 경우
					visit[next] = visit[now] + 1;
					queue.add(next); // bfs 큐에다가 방문한 노드 추가
				}
			}

		}
	}
}
