import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int L;
    public static int R;

    public static int[][] ground;
    public static int[][] shareCountries;
    public static boolean flag;
    public static int answer;
    public static int countryNumber;
    public static int countCountries;
    public static int sum;

    public static ArrayList<int[]> countries;


    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ground = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            shareCountries = new int[N][N]; // 새로운 날이 시작될 때마다 전부 초기화
            countryNumber = 1;
            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (shareCountries[i][j] == 0) {
                        sum = 0;
                        find(i, j); // 연합 지정이 안 된 경우 find
                        countryNumber++;
                        countCountries = 0;
                    }
                }
            }

            if (!flag) {
                break;
            }

            answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void find(int row, int col) {

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, col});
        shareCountries[row][col] = countryNumber;

        ArrayList<int[]> countries = new ArrayList<>();
//        countries.add(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] s = stack.pop();
            countries.add(s);
            int r = s[0];
            int c = s[1];

            int nowPeople = ground[r][c];
            sum += nowPeople;

            countCountries++; // 현재 들어온 나라 증가시키고
//            shareCountries[r][c] = countryNumber; // 방문

            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
                    continue;
                }

                if (shareCountries[nextR][nextC] != 0) {
                    continue;
                }

                int nextPeople = ground[nextR][nextC]; // 예측값

                if ((Math.abs(nextPeople - nowPeople) >= L) && (Math.abs(nextPeople - nowPeople) <= R)) {
                    flag = true;
                    stack.push(new int[] {nextR, nextC});
                    shareCountries[nextR][nextC] = countryNumber;
                }
            }
        }

        int newPeople = sum / countCountries;
        for (int[] country : countries) {

            ground[country[0]][country[1]] = newPeople;
        }

    }

}