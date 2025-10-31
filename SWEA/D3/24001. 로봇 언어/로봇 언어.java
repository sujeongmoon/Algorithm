import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            String distance = br.readLine();

            char[] distanceArray = distance.trim().toCharArray();

            int ans = 0;   // 정답: 접두사별 최대 |A| + Q
            int fixed = 0; // 확정된 거리
            int q = 0;     // 접두사 내 '?' 개수

            for (int i = 0; i < distanceArray.length; i++) {
                char ch = distanceArray[i];
                if (ch == 'L') fixed -= 1;
                else if (ch == 'R') fixed += 1;
                else q += 1; // '?'
                int cand = Math.abs(fixed) + q; // 후보
                if (cand > ans) ans = cand;
            }

            bw.write(Integer.toString(ans));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
