
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	
	private static ArrayList<Integer>[] graph; //ArrayList 배열
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] isVisited;
	//private static ArrayList<Integer> answer = new ArrayList<>();
	
	private static void dfs(int v) {
		isVisited[v] = true;
		
		sb.append(v).append(' ');
		for(int next : graph[v]) {
			if (!isVisited[next]) {
				dfs(next);
			}
		}
	}
	
	private static void bfs(int v) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		isVisited[v] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(' ');
			for(int next : graph[now]) {
				if(!isVisited[next]) {
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		isVisited = new boolean[N+1];

		dfs(V);
		sb.append('\n');
		
		isVisited = new boolean[N+1];
		
		bfs(V);
		sb.append('\n');
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
