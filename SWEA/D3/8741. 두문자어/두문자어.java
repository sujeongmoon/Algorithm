
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
            StringBuilder sb = new StringBuilder();
            
            String word1 = st.nextToken().toUpperCase();
            String word2 = st.nextToken().toUpperCase();
            String word3 = st.nextToken().toUpperCase();
            
            sb.append('#').append(test_case).append(' ');
            sb.append(word1.charAt(0)).append(word2.charAt(0)).append(word3.charAt(0)).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}