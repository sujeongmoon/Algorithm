import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] T; // 기간
	static int[] P; // 금액

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, findMax(i));
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();

	}

	public static int findMax(int idx) {

		int t = T[idx];
		int p = P[idx];
		int max = 0;

		if (idx + t > N) {
			return 0;
		}

		for (int i = idx + t; i < N; i++) {
			max = Math.max(max, findMax(i));
		}

		return max + p;
	}

}
