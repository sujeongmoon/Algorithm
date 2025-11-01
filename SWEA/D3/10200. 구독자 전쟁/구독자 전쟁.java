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
            
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            StringBuilder sb = new StringBuilder();
            
            sb.append('#').append(test_case).append(' ');
            sb.append(Math.min(A,B)).append(' ');
            if ((N - (A + B)) > 0) {
                sb.append('0');
            } else {
            	sb.append(Math.abs(N - (A + B)));
            }
            sb.append('\n');
            
            bw.write(sb.toString());
		}

        
        bw.flush();
        bw.close();
        
	}
}