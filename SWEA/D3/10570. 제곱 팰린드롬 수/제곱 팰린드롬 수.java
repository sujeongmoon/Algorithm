
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            StringBuilder sb = new StringBuilder();
            
            int[] pd = {1, 2, 3, 11, 22};
			
            for (int i : pd) {
                if (i*i >= start && i * i <= end) {
                    answer++;
                } else if (i * i > end) {
                    break;
                }
            }
            
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}