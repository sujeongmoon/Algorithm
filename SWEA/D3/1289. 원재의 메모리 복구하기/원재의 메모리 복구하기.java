import java.util.Scanner;
import java.io.FileInputStream;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		String s = sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {

			s = sc.nextLine(); // 바꿔야 할 수
			boolean isOne = false; // 1인지 아닌지 여부 체크
			int answer = 0; // 고쳐야 하는 횟수
			
			for (int i = 0; i < s.length(); i++) {
				if ((s.charAt(i) == '1') && !isOne) {
					isOne = true;
					answer++;
				} else if ((s.charAt(i) == '0') && isOne) {
					isOne = false;
					answer++;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}