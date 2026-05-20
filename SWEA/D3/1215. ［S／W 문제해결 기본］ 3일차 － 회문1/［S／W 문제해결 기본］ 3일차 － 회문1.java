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
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int length = sc.nextInt(); // 회문 길이
			String s = sc.nextLine();
			char[][] arr = new char[8][8];
			int answer = 0;

			// 배열 채우기
			for (int i = 0; i < 8; i++) {
				s = sc.nextLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}

			// 가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - length; j++) {
					int[] cropArr = new int[length]; // 자른 배열
					for (int k = 0; k < length; k++) {
						cropArr[k] = arr[i][j + k];
					}

					boolean flag = true;
					for (int k = 0; k < length / 2; k++) {
						if (cropArr[k] != cropArr[length - k - 1]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						answer++;
					}
				}
			}
			
			// 세로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - length; j++) {
					int[] cropArr = new int[length]; // 자른 배열
					for (int k = 0; k < length; k++) {
						cropArr[k] = arr[j + k][i];
					}

					boolean flag = true;
					for (int k = 0; k < length / 2; k++) {
						if (cropArr[k] != cropArr[length - k - 1]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						answer++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}