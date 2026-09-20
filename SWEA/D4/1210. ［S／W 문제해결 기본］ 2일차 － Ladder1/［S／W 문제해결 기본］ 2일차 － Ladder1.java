import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{


    /**
     *
     * [문제 설명]
     * 어느 사다리를 고르면 x표시에 도착하게 될지 고르자
     *
     * [출력]
     * 어느 사다리를 고르면 x표시에 도착할지 고르자
     * 지정된 도착점(2)에 대응되는 출발점 x(사다리->1)를 반환하는 코드
     *
     * [입력]
     * 100*100의 배열
     *
     * [풀이 방법]
     * 2 좌표를 미리 저장해두고, 위로 거슬러 올라가는 방법을 사용
     * 가로 방향에 1이 있다면, 0이 나올 때까지 쭉 이동한다
     * r이 0인 경우의 c를 찾으면 정답
     *
     * [고려사항]
     * 10개의 테스트케이스 고정
     *
     */
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine(); // 테스트케이스 번호 넘기기
            int[][] arr = new int[100][100];
            int xCol = 0; // 도착지점의 col값

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 2) {
                        xCol = j;
                    }
                }
            }

            for (int i = 99; i >= 0; i--) {

                 boolean isMoved = false; // 이동했는지 판별하는 변수
                // 오른쪽으로 이동할 수 있다면 이동
                while (xCol + 1 < 100 && arr[i][xCol + 1] == 1) {
                    isMoved = true;
                    xCol++;
                }
                // 오른쪽으로 이동하지 않았고 왼쪽으로 이동할 수 있다면 이동
                while (!isMoved && xCol - 1 >= 0 && arr[i][xCol - 1] == 1) {
                    xCol--;
                }
            }

            sb.append("#").append(t).append(" ").append(xCol).append("\n");

        }

        System.out.println(sb.toString());
    }


}
