import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		String s = sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {

			s = sc.nextLine(); // 바꿔야 할 수
			boolean isOne = false; // 1인지 아닌지 여부 체크
			int answer = 0; // 고쳐야 하는 횟수
			
			for (int i = 0; i < s.length(); i++) {
				if (((s.charAt(i) == '1') && isOne) || ((s.charAt(i) == '0') && !isOne)) {
					continue;
				}
				isOne = !isOne;
				answer++;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}