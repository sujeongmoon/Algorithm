import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int one = 0;
	static int zero = 0;
	static int minusOne = 0;

	private static void checkPaper(int[][] paper) {
		int nowNumber = paper[0][0];

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if (nowNumber != paper[i][j]) {
					cutPaper(paper);
					return;
				}
			}
		}

		if (nowNumber == 1) {
			one++;
		} else if (nowNumber == 0) {
			zero++;
		} else if (nowNumber == -1) {
			minusOne++;
		}

	}

	private static void cutPaper(int[][] paper) {
		int newLength = (paper.length + 1) / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[][] newPaper = new int[newLength][newLength];
				for (int k = 0; k < newLength; k++) {
					for (int l = 0; l < newLength; l++) {
						newPaper[k][l] = paper[i * newLength + k][j * newLength + l];
					}
				}
				checkPaper(newPaper);
			}
		}

	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		checkPaper(paper);

		sb.append(minusOne).append("\n").append(zero).append("\n").append(one).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
