import java.util.*;
import java.io.*;

public class Main {

    public static char[][] gear;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gear = new char[4][8];
        for (int i = 0; i < 4; i++) {
            gear[i] = br.readLine().toCharArray();
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowGear = Integer.parseInt(st.nextToken()) - 1;
            boolean isClock = st.nextToken().equals("1");

            rotateGear(nowGear, isClock, 0);




        }

        int answer = 0;
        /*
        if (gear[0][2] == '1') {
            answer += 1;
        }
        if (gear[1][2] == '1') {
            answer += 2;
        }
        if (gear[2][2] == '1') {
            answer += 4;
        }
        if (gear[3][2] == '1') {
            answer += 8;
        }
        */

        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == '1') {
                answer += (1 << i);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();

    }

    public static void rotateGear(int nowGear, boolean isClock, int state) {
        // state 0 -> 시작, 왼쪽오른쪽 다 봐야함
        // state -1 -> 오른쪽에서 왼쪽으로 옴, 즉 오른쪽 볼 필요 없음, 왼쪽만 보자
        // state 1 -> 왼쪽에서 오른쪽으로 옴, 즉 왼쪽 볼 필요 없음, 오른쪽만 보자

        if (state <= 0 && nowGear != 0) {
            if (gear[nowGear][6] != gear[nowGear-1][2]) {
                rotateGear(nowGear - 1, !isClock, -1);
            }

        }
        if (state >= 0 && nowGear != 3) {
            if (gear[nowGear][2] != gear[nowGear+1][6]) {
                rotateGear(nowGear + 1, !isClock, 1);
            }
        }

        char[] nowGearClone = gear[nowGear].clone();

        if (isClock) {
            for (int i = 0; i < 8; i++) {
                gear[nowGear][(i+1)%8] = nowGearClone[i];
            }
        } else {
            for (int i = 0; i < 8; i++) {
                gear[nowGear][i] = nowGearClone[(i+1)%8];
            }
        }
    }

}