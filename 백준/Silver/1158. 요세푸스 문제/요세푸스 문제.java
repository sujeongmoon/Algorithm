import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int[] answer = new int[N];
		int i = 0;
		int count = 1;

		while (!queue.isEmpty()) {
			int now =  queue.poll();

			if (count == K) {
				answer[i] = now;
				i++;
				count = 1;
			} else {
				queue.addLast(now);
				count++;
			}

		}

		StringBuilder sb = new StringBuilder();

		sb.append('<');

		for (int k = 0; k < N-1; k++) {
			sb.append(answer[k]).append(", ");
		}
		sb.append(answer[N-1]).append('>');

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
