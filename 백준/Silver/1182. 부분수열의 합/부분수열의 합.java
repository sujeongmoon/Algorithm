import java.io.*;
import java.util.*;

public class Main {

	public static int S;
	public static int N;
	public static int[] arr;

	public static int answer; // 수열의 원소를 다 더해서 값이 S가 된 경우

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정수 개수
		S = Integer.parseInt(st.nextToken()); // 목표값

		arr = new int[N]; // N개의 수들을 담는 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		backtracking(0, 0);

		if (S==0) {
			answer --;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	public static void backtracking(int idx, int sum) { // 현재 인덱스, 현재까지 더한 값

		if (idx ==N) {
			if (sum == S) {
				answer++;
			}
			return;
		}

		// 포함하는 경우
		backtracking(idx+1, sum+arr[idx]);
		// 포함하지 않는 경우
		backtracking(idx+1, sum);

	}

}
