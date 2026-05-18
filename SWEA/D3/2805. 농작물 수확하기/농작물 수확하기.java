import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[][] farm = new int[N][N];
			String s = sc.nextLine();

			int answer = 0;

			for (int i = 0; i < N; i++) {
				s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}

			int center = (N / 2); // 중앙 인덱스
			int now = 0;

			for (int i = 0; i < N; i++) {// 현재 라인 수
				for (int j = center - now; j <= center + now; j++) {
					answer += farm[i][j];
				}
				if (i < center) {
					now++;
				} else {
					now--;
				}

			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}