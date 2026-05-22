import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	static int maxResult;
	static HashSet<String>[] visited; // 어떤 문자열으 방문했는지 기록할 세트 배열
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			String nums = sc.next();
			int change = sc.nextInt();
			StringBuilder sb = new StringBuilder(nums); // 문자열 교체 쉽게 하기 위해
			maxResult = 0;
			
			visited = new HashSet[change+1];
			for (int i = 0; i <= change; i++) {
				visited[i] = new HashSet<>();
			}

			dfs(sb, change);

			System.out.println("#" + test_case + " " + maxResult);
		}
	}
	
	public static void dfs(StringBuilder sb, int change) {
		if (change == 0) {
			// 다 채운 경우
			int currentNum = Integer.parseInt(sb.toString());
			maxResult = Math.max(maxResult, currentNum);
			return; // 함수 종료
		}
		
		String currentStr = sb.toString();
		if (visited[change].contains(currentStr)) {
			// 이미 해당 str을 가지고 있는 경우 가지치기
			return;
		}
		// 처음 보는 str이라면 세트에 기록
		visited[change].add(currentStr);
		
		// 반복 조건 - 바꿀 수 있는 두 자리 조합을 모두 시도하기
		int len = sb.length();
		for (int i = 0; i< len - 1; i++) {
			for (int j = i+1; j < len; j++) {
				char temp = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(j));
				sb.setCharAt(j, temp);
				dfs(sb, change-1);
				sb.setCharAt(j, sb.charAt(i));
				sb.setCharAt(i, temp);
			}
			 
		}
	}

}