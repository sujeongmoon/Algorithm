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

		int N = Integer.parseInt(br.readLine());

		int[] countingSort = new int[10001]; // 1부터 넣을 거라서.

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			countingSort[n]++;
		}

		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < countingSort[i]; j++) {
				sb.append(i + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
