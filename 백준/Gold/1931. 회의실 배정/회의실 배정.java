import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] conferences = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            conferences[i][0] = Integer.parseInt(st.nextToken());
            conferences[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conferences,
                Comparator.comparingInt((int[] o) -> o[1])
                    .thenComparingInt((int[] o) -> o[0]));

        int count = 0;
        int now = -1;
        for (int i = 0; i < N; i++) {
            if (conferences[i][0] >= now) {
                count++;
                now = conferences[i][1];
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

}