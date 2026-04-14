
import java.io.*;

public class Main {

	public static int N;
	public static int[] cols;

	public static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		cols = new int[N];

		backtracking(0);

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	public static void backtracking(int row) {

		// 종료조건
		if (row == N) {
			answer++;
			return;
		}
		// 전에 미리 다 겹치면 컷

		for (int i = 0; i < N; i++) {
			if (isPossible(row, i)) { // 놓을 수 있는지 확인 (유망함수)
				cols[row] = i;        // 퀸 배치
				backtracking(row + 1); // 다음 행으로 이동

			}
		}

	}

	public static boolean isPossible(int row, int now) {

		for (int i = 0; i < row; i++) {
			if (cols[i] == now) {
				return false;
			}
			if (Math.abs(row - i) == Math.abs(now - cols[i])) {
				return false;
			}
		}

		return true;

	}



}
