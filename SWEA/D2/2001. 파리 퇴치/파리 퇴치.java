
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] nArray = new int[N][N];

			int max = 0;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					nArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += nArray[i + k][j + l];
						}
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
				
			}

			sb.append('#').append(test_case).append(' ').append(max).append('\n');
			bw.write(sb.toString());

		}
		bw.flush();
		bw.close();

	}

}
