import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] T; // 기간
	static int[] P; // 금액
	static int[] dp; // 값을 저장할 배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		dp = new int[N];
		Arrays.fill(dp, -1);

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// int max = findMax(0);

		for (int i = N - 1; i >= 0; i--) {
			int t = T[i];
			int p = P[i];

			int nextMax = (i + 1 < N) ? dp[i + 1] : 0;

			if (i + t > N) {
				dp[i] = nextMax;
			} else {
				int afterConsult = (i + t < N) ? dp [i + t] : 0;
				dp[i] = Math.max(p + afterConsult, nextMax);
			}
		}


		bw.write(dp[0] + "\n");
		bw.flush();
		bw.close();

	}

	// public static int findMax(int idx) {
	//
	// 	if (idx >= N) {
	// 		return 0;
	// 	}
	//
	// 	// 이미 계산한 적 있다면 dp 사용
	// 	if (dp[idx] != -1) {
	// 		return dp[idx];
	// 	}
	//
	// 	int t = T[idx];
	// 	int p = P[idx];
	// 	int answer = findMax(idx + 1);
	//
	// 	if (idx + t > N) {
	// 		dp[idx] = answer;
	// 		return answer;
	// 	}
	//
	// 	// 오늘 상담을 한다면 / 상담을 안한다면
	// 	answer = Math.max(findMax(idx + t) + p, answer);
	//
	// 	dp[idx] = answer;
	// 	return answer;
	// }

}