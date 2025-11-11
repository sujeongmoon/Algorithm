
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
            boolean isOdd = true;
            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(st.nextToken()) %2 == 0) {
                    isOdd = false;
                    break;
                }
            }
            if (isOdd == true) {
                bw.write("2\n");
            } else {
                bw.write("1\n");
            }
		}
        bw.flush();
        bw.close();
	}
}