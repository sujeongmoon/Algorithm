import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		int[] countingSort = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - 'a';
			countingSort[n]++;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < countingSort[i]; j++) {
				sb.append((char)('a' + i));
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
