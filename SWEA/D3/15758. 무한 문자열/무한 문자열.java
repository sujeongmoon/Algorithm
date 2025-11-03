import java.util.*;
import java.io.*;

class Solution
{
    public static int getGcd(int a, int b) {
    	if (a%b == 0) {
            return b;
        }
        return getGcd(b, a%b);
    }
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            sb1.append(a).append(b);
            sb2.append(b).append(a);
            
            if (sb1.toString().equals(sb2.toString())) {
                sb.append('#').append(test_case).append(" yes\n");
            } else {
                sb.append('#').append(test_case).append(" no\n");
            }
           bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
	}
}