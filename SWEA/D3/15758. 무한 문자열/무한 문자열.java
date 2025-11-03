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
           for (int j = 0; j < shortWord.length(); j++) {
               sb.append(longWord);
           }
            String longLongWord = sb.toString();
            sb.setLength(0);
            
            boolean flag = true;
            for (int j = 0; j < longWord.length(); j++) {
                for (int k = 0; k < shortWord.length(); k++) {
                    if (!(longLongWord.charAt(j*shortWord.length() + k) == shortWord.charAt(k))) {
                        flag = false;
                        break;
                    }
                }
                if (flag == false) {
                    break;
                }
            }
            if (flag == true) {
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