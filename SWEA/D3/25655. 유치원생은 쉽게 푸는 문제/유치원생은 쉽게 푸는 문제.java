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
            int X = Integer.parseInt(br.readLine());
            sb.setLength(0);
            
            if (X==1) {
                bw.write(sb.append("0\n").toString());
                continue;
            }
            
            if (X%2==1) {
                sb.append(4);
            }
            for (int i = 0; i < X/2; i++) {
                sb.append(8);
            }
            bw.write(sb.append('\n').toString());
        }
        bw.flush();
        bw.close();
	}               
}