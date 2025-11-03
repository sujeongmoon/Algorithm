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
            String shortWord = st.nextToken();
            String longWord = st.nextToken();
            StringBuilder sb = new StringBuilder();
            
            if (shortWord.length() > longWord.length()) {
                String temp = longWord;
                longWord = shortWord;
                shortWord = temp;
            } else if (longWord.length() == shortWord.length()) {
                if (longWord.equals(shortWord)) {
                    sb.append('#').append(test_case).append(" yes\n");
                } else {
                	sb.append('#').append(test_case).append(" no\n");
                }
                bw.write(sb.toString());
                continue;
            } // shortWord, longWord 지정
			
           // longWord 늘리기
            // 최대공약수 구하기
            int gcd = getGcd(longWord.length(), shortWord.length());
            int lsm = longWord.length()*shortWord.length() / gcd;
            
            for (int j = 0; j < lsm/longWord.length(); j++) {
                sb.append(longWord);
            }
            String longLongWord = sb.toString();
            sb.setLength(0);
            
            for (int j = 0; j < lsm/shortWord.length(); j++) {
                sb.append(shortWord);
            }
            String shortShortWord = sb.toString();
            sb.setLength(0);
            
            if (longLongWord.equals(shortShortWord)) {
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