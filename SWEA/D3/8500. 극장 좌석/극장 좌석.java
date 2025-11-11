
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
            int N = Integer.parseInt(br.readLine()); // N명의 사람 존재
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer[] array = new Integer[N];
            
            for(int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(array, Collections.reverseOrder());
            int answer = array[0];
            
            for (int i = 0; i < array.length; i++) {
                answer += array[i]+1;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
    }
}