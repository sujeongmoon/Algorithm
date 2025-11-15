
/////////////////////////////////////////////////////////////////////////////////////////////
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
            
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            
            char[] cities = br.readLine().toCharArray();
            int check = 0;
            int answer = 0;
            
            for (int i = 0; i < cities.length; i++) {
                if (cities[i] == '0') {
                    check++;
                    if (check == D) {
                        answer++;
                        check = 0;
                    }
                } else if (cities[i] == '1') {
                    check = 0;
                }
            }
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}