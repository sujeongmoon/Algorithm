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
            StringBuilder sb = new StringBuilder();
            Long L = Long.parseLong(br.readLine());
            Long answer = 0L;
            
            answer =((L-1)/2)*(L-1)/2;

            
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}