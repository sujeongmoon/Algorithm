
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
		
			String P = br.readLine();
            String Q = br.readLine();
            
            StringBuilder nextP = new StringBuilder();
            nextP.append(P).append('a');
            
            StringBuilder sb = new StringBuilder();
            if (nextP.toString().equals(Q)) {
                sb.append('#').append(test_case).append( " N\n");
            } else {
                sb.append('#').append(test_case).append( " Y\n");
            }
			bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}