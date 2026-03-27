import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int token = Integer.parseInt(st.nextToken());
			arr[i] = token;
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		for (int i = 0; i < N; i++) {
			sb.append(result[i] != 0 ? result[i] : -1).append(' ');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
