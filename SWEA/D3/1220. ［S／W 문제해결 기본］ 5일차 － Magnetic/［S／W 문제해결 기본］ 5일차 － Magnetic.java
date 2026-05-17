
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int answer = 0; // 교ㅗ착상태 수
			int l = sc.nextInt(); // 한 변의 크기
			int[][] arr = new int[l][l]; // 정사각형 변
			String s = sc.nextLine();
			
			for (int i = 0; i < l; i++) {
				s = sc.nextLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j = 0; j < l; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < l; i++) {
				// 세로로 
				boolean isN = false; // N이 있는지 여부
				for (int j = 0; j < l; j++) {
					int now = arr[j][i];
					if (now == 1) { // N인 경우
							isN = true;
					} else if (now == 2) { // s인 경우
						if (isN) {
							answer++;
							isN = false;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
