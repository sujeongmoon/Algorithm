import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static int[][] arr;
	public static int[] dp;
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt(); // 재료 개수
			int L = sc.nextInt(); // 제한 칼로리
			
			arr = new int[N][2]; // 정보 담은 배열
			dp = new int[L+1]; // 칼로리에 대한 DP
			
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt(); // 맛에 대한 점수
				arr[i][1] = sc.nextInt(); // 칼로리
			}
			
			for (int i = 0; i <N; i++) {
				int taste = arr[i][0];
				int calorie = arr[i][1];
				
				for (int j = L; j >= calorie; j--) {
					dp[j] = Math.max(dp[j - calorie] + taste, dp[j]);
				}
			}
			
			System.out.println("#" + test_case + " " + dp[L]);

		}
	}
}