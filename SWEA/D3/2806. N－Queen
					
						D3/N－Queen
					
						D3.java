import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static int N;
	private static int[] board;
	private static int answer;
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt(); // N의 수
			board = new int[N]; // N 배열 - 인덱스는 row, 내용은 col 의미
			answer = 0;
			
			backtracking(0);
			
			System.out.println("#" + test_case + " " + answer);
			
			
		}
	}
	
	public static void backtracking(int idx) { // idx는 이제 넣을 인덱스 값
		
		// 종료조건 - 만약 인덱스가 N-1에 도달하는 데에 성공했다면 answer++
		if (idx == N) {
			answer++;
			return;
		}
		

		for (int i = 0; i < N; i++) {
			// i가 현재 idx에 들어갈 값
			
			boolean flag = true; // 넣을 수 있는지 없는지 체크
			// j는 현재까지 채워진 board 배열을 순회
			for (int j = 0; j < idx; j++) {
				
				// 가로
				if (board[j] == i) {
					flag = false;
					break;
				}
				
				// 세로 는 없음
				
				// 대각선
				if ((Math.abs(idx - j) == (Math.abs(i - board[j])))) {
					flag = false;
					break;
				}
				
			}
			if (flag) { // 전부 다 통과한 경우
				// 넣기
				board[idx] = i;
				backtracking(idx+1);
				// 빼기
				board[idx] = 0;
			}
		}	
	}
}