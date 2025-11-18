import java.util.*;
import java.io.*;

class Solution
{  
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            sb.setLength(0);
            int[][] snailArray = new int[N][N];

            // 방향: 오른쪽, 아래, 왼쪽, 위
            int[] di = {0, 1, 0, -1};
            int[] dj = {1, 0, -1, 0};

            int dir = 0; // 0: right, 1: down, 2: left, 3: up
            int i = 0;
            int j = 0;

            for (int snail = 1; snail <= N * N; snail++) {
                snailArray[i][j] = snail;

                int ni = i + di[dir];
                int nj = j + dj[dir];

                // 다음 칸이 범위를 벗어나거나 이미 채워져 있으면 방향 전환
                if (ni < 0 || ni >= N || nj < 0 || nj >= N || snailArray[ni][nj] != 0) {
                    dir = (dir + 1) % 4;
                    ni = i + di[dir];
                    nj = j + dj[dir];
                }

                i = ni;
                j = nj;
            }

            
            sb.append('#').append(test_case).append('\n');
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++) {
                    sb.append(snailArray[k][l]);
                    if (l != N - 1) {
                        sb.append(' ');
                    }
                }
                sb.append('\n');
            }
            bw.write(sb.toString());
            
		}
        bw.flush();
        bw.close();
	}
}