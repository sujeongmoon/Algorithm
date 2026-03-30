import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			ArrayDeque<String> ad = new ArrayDeque<>();
			String arrayStr = br.readLine();
			StringTokenizer st = new StringTokenizer(arrayStr,"[,]");

			for (int i = 0; i < n; i++) {
				ad.offer(st.nextToken());
			}

			sb.append(funcP(ad, p));

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static String funcP(ArrayDeque<String> ad, String p) {


		boolean isStack = false;
		StringBuilder sb = new StringBuilder();
		sb.append('[');

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == 'R') {
				isStack = !isStack;
			} else if (p.charAt(i) == 'D') {
				if (ad.isEmpty()) {
					return "error\n";
				}
				if (isStack) {
					ad.pollLast();
				} else {
					ad.pollFirst();
				}
			}
		}


		while (!ad.isEmpty()) {
			if  (isStack) {
				sb.append(ad.pollLast()).append(',');
			} else {
				sb.append(ad.pollFirst()).append(',');
			}
		}

		if(sb.length() > 1) {
			sb.setLength(sb.length()-1);
		}
		sb.append("]\n");
		return sb.toString();
	}

}
