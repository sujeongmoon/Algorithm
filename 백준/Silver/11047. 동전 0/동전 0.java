import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static int[] values;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 동전의 종류
        K = Integer.parseInt(st.nextToken()); // 만들고자 하는 액수
        values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        while(K != 0) {

            for (int i = N-1; i >= 0; i--) {
                if (values[i] <= K) {
                    K -= values[i];
                    answer++;
                    break;
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

}