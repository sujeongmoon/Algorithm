import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		// 테스트케이스 T
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 마지막 N비트
			int M = sc.nextInt(); // M(이진수로 표현해야하는 수)

			String m = Integer.toString(M, 2); // 이진수 STring

			// N이 m.length보다 크다면 무조건 틀린거
			// N이 m.length보다 같거나 작다면, 뒤으 ㅣN부터 비교해서 비트가 하나라도 꺼져있으면 OFF 출력 켜져있으면 ON 출력

			boolean isON = false;

			if (N > m.length()) {
				
			} else if (N <= m.length()) {
				for (int i = 0; i < N; i++) {
					if (m.charAt(m.length() - 1 - i) == '0') {
						// System.out.println("#" + test_case + " " + "OFF");
						break;
					}
					if (i == N-1) { // 다 켜져있는 경우
						isON = true;
					}
				}
			}

			String answer;

			if (isON) {
				answer = "ON";
			} else {
				answer = "OFF";
			}

			System.out.println("#" + test_case + " " + answer);

		}

	}
}
