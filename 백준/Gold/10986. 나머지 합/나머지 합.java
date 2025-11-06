import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] cnt = new long[M];
        cnt[0] = 1; 

        long sum = 0;
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum = (sum + Long.parseLong(st.nextToken())) % M;
            ans += cnt[(int) sum]; 
            cnt[(int) sum]++;    
        }

        System.out.println(ans);
    }
}
