import java.util.*;
import java.io.*;

public class Main{

	// public static StringBuilder sb = new StringBuilder(); // sb활용해서 write할 것
	public static int N; // 1~N열까지의 범위
	public static int M; // 수열에서 골라야하는 수
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 1~N까지의 범위
		M = Integer.parseInt(st.nextToken()); // 수열에서 골라야하는 수

		backtracking(0, 1, new StringBuilder());
		bw.flush();
		bw.close();

	}

	public static void backtracking(int depth, int start, StringBuilder sb) throws IOException{
		// depth: 현재까지 몇 개의 숫자를 골랐는지
		// start: 이번 자리에 쓸 수 있는 최소 숫자

		if (depth == M) {
			bw.write(sb.toString());
			bw.write('\n');
			return;
		}


		for (int i = start; i <= N; i++) {

			sb.append(i).append(' ');
			backtracking(depth+1, i+1, sb);
			sb.setLength(sb.length()-2);
		}

	}

}
