
import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N;
	static int K;
	static int[] arr;
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 배열 크기
			K = sc.nextInt(); //목표 sum값
			
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			int[] dp = new int[K + 1];
			dp[0] = 1;
			
			for (int i = 0; i < N; i++) {
				int num = arr[i]; // 이번에 고려할 숫자
				
				for (int j = K; j >= num; j--) {
					dp[j] += dp[j-num]; 
					// j==K인경우 dp[0] = 1이라서 더해짐
				}
			}
			System.out.println("#" + test_case + " " + dp[K]);
		}
	}
}