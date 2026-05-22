import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N;
	static int M;
	static List<List<Integer>> list;
	static boolean[] isVisited;
	static int answer;
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 정점 개수
			M = sc.nextInt(); //간선 정보
			answer = Integer.MIN_VALUE;
			
			list = new ArrayList<>(); // 그래프 정보
		
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				list.get(p1).add(p2);
				list.get(p2).add(p1); // 양방향 추가
			}
			
			isVisited = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				dfs(i, 1);
			}
			
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static void dfs(int node, int length) {
		
		// 만약 더이상 갈 곳이 없으면 나가기
		if (length > answer) {
			answer = length;
		}
		
		isVisited[node] = true;
		
		for (int i : list.get(node)) {
			if (isVisited[i]) {
				continue; // 방문한 노드면 패스
			}
			dfs(i, length+1);
		}
		
		isVisited[node] = false;
		
	}
}