import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++){
			int nNumber = Integer.parseInt(st.nextToken());
			map.put(nNumber, map.getOrDefault(nNumber, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int mNumber = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(mNumber, 0));
			sb.append(' ');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}