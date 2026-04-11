import java.util.*;
import java.io.*;

public class Main {

	public static int N;

	// min,max를 전역에서 관리
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;

	public static int[] arr;
	public static int[] operators = new int[4]; // 연산자 개수 저장

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		// + - * /
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		dfs(arr[0], 1);

		bw.write(Integer.toString(max));
		bw.write("\n");
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	//
	public static void dfs(int num, int idx) {

		// 끝나는 조건 : 마지막 숫자인 경우 (연산 불가)
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;

				if (i == 0) {
					dfs(num + arr[idx], idx + 1);
				} else if (i == 1) {
					dfs(num - arr[idx], idx + 1);
				} else if (i == 2) {
					dfs(num * arr[idx], idx + 1);
				} else if (i == 3) {
					dfs(num / arr[idx], idx + 1);
				}

				// 재귀가 끝나고 돌아오면 연산자 개수 복구
				operators[i]++;

			}
		}
	}
}
