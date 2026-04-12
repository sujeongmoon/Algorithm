import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int L; // 암호의 길이
	static int C; // 입력받은 알파벳 갯수

	static char[] charArray; // 알파벳들이 담긴 배열
	static HashSet<Character> hashSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		charArray = new char[C]; // 알파벳들이 담긴 배열

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			charArray[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(charArray);

		dfs(0, 0);

		bw.flush();
		bw.close();

	}

	public static void dfs(int start, int depth) throws IOException {

		if (depth == L) {
			String s = sb.toString();
			int aeiou = 0;
			int notaeiou = 0;

			for (int i = 0; i < s.length(); i++) {
				if (hashSet.contains(s.charAt(i))) {
					aeiou++;
				} else {
					notaeiou++;
				}
			}

			if (aeiou >= 1 && notaeiou >= 2) {
				bw.write(s);
				bw.write('\n');
			}
			return;
		}

		for (int i = start; i < C; i++ ) {
			sb.append(charArray[i]);
			dfs(i+1, depth+1);
			sb.setLength(sb.length()-1);
		}
	}

}
