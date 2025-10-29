import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {


        /*
        조건 : 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권 확보된 세대
        리턴값 : 조망권이 확보된 세대의 수 반환

        제약 사항 : 가로 길이는 1000 이하
                  맨 왼쪽 두 칸과 오른쪽 두 칸에는 건물이 지어지지 않음
                  각 빌딩의 높이는 최대 255

        입력 : 총 10개의 테스트케이스
              각 테스트케이스의 첫 번째에는 건물의 개수 N(4 <= N <= 1000)
              두 번째 줄에는 N개의 건물의 높이 (0 <= 건물 높이 <= 255)
              맨 왼쪽 두 칸과 오른쪽 두 칸에 있는 건물의 높이는 항상 0

        출력 : # 부호와 함께 테스트케이스의 번호를 출력하고, 공백문자 후 조망권이 확보된 세대의 수 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 1; i <= 10; i++) {
            int houseLength = Integer.parseInt(br.readLine());
            int[] houseArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int viewHouse = 0;

            for (int j = 2; j < houseLength - 2; j++) {
                int max = Math.max(Math.max(houseArray[j - 2], houseArray[j - 1]), Math.max(houseArray[j + 1], houseArray[j + 2]));

                if (max < houseArray[j]) {
                    viewHouse += houseArray[j] - max;
                }
            }

            bw.write("#" + i + " " + viewHouse + "\n");

        }

        bw.flush();
        bw.close();
    }
}