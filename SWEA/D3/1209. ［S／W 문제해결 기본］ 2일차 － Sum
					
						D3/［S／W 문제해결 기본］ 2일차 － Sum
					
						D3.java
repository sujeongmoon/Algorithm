import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt(); // 테스트케이스 번호
			int answer = Integer.MIN_VALUE; // 가장 큰 값
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 가로세로 비교
			for (int i = 0; i < 100; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 100; j++) {
					// rowSum
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				answer = Math.max(Math.max(answer, colSum), rowSum);
			}
			
			// 대각선 비교
			int ztoh = 0;
			int htoz = 0;
			
			for (int i = 0; i < 100; i++) {
				ztoh += arr[i][i];
				htoz += arr[i][99-i];
			}
			answer = Math.max(Math.max(answer, htoz), ztoh);
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}