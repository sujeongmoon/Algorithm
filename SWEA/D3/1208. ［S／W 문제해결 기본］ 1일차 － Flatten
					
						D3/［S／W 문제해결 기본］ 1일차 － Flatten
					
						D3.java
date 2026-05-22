
import java.util.Arrays;
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
			int count = sc.nextInt();
			int[] landArr = new int[100];

			// 정렬하기
			for (int i = 0; i < 100; i++) {
				landArr[i] = sc.nextInt();
			}

			while (count != 0) {
				Arrays.sort(landArr); // 오름차순 정렬
				
				count--;
				landArr[0]++;
				landArr[landArr.length - 1]--;

			}

			Arrays.sort(landArr);
			int diff = landArr[landArr.length - 1] - landArr[0];

			System.out.println("#" + test_case + " " + diff);

		}
	}
}