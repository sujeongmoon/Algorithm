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
            int testCaseNumber = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            int value = -1;
            int maxFrequency = -1;
            int score = -1;
            int frequency = -1;
            
            while(st.hasMoreTokens()) {
                score = Integer.parseInt(st.nextToken());
                frequency = frequencyMap.getOrDefault(score, 0) + 1;
                frequencyMap.put(score, frequency);
                
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    value = score;
                } else if (frequency == maxFrequency) {
                    if (score > value) {
                        value = score;
                    }
                            
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(testCaseNumber).append(" ").append(value).append("\n");
            bw.write(sb.toString());
		}
        bw.flush();
        bw.close();
	}
}