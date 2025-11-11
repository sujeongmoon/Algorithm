
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            
            int D = Integer.parseInt(st.nextToken()); // 기본공격 
            int L = Integer.parseInt(st.nextToken()); // 익힌 공격의 레벨
            int N = Integer.parseInt(st.nextToken()); // 앞으로 때릴 횟수
            
            int totalAttack = 0;
            
            for (int n = 0; n < N; n++) {
                totalAttack += (D * ( 1 + n * L * 0.01));
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(test_case).append(' ').append(totalAttack).append('\n');
			bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}