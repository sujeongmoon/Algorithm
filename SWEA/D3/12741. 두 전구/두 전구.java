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
            
            int xStart = Integer.parseInt(st.nextToken());
            int xEnd = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());
            int yEnd = Integer.parseInt(st.nextToken());
            
            int start = Math.max(xStart, yStart);
            int end = Math.min(xEnd,yEnd);
            
            int answer = start<end ? end - start : 0;
            
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}