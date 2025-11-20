
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int M;
	static int[] nums;
	static boolean[] isVisited;

	static StringBuilder sb = new StringBuilder();

	static void backtrack(int depth) {
		if (depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(nums[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			
			if(!isVisited[i]) {
				isVisited[i] = true; //현재 재귀 내에서 바문처리
				nums[depth] = i + 1;
				backtrack(depth+1);
				isVisited[i] = false; // 방문 끝나면 다시 false 처리
			}
		}
		
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[M];
		isVisited = new boolean[N];
	

		backtrack(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
