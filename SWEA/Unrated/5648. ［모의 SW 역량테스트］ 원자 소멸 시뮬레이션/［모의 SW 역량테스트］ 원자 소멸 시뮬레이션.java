
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	/**
	 * [ 문제 ]
	 * 원자들의 움직임을 시뮬레이션
	 * 원자들은 이차원 평면에서 이동하며, 두 개 이상의 원자가 충돌할 경우, 충돌한 원자들은 각자 보유한 에너지를 모두 방출하고 소멸
	 * - 원자의 움직임
	 * 1. 최초 위치는 2차원 평면상의 x, y
	 * 2. 원자는 각자 고유의 움직이는 방향을 가짐 (상하좌우)
	 * 3. 모든 원자들의 이동속도 - 1초에 1
	 * 4. 모든 원자들은 최초 위치에서 동시에 이동을 시작함
	 * 5. 두 개 이상의 원자가 동시에 충돌할 경우 충돌한 원자들은 보유한 에너지를 모두 방출하고 수멸
	 * 
	 * 
	 * [ 주의사항 ]
	 * 혹시 한 칸이 남은 경우 -> .5초로 계산되는 것 주의해야함
	 * 
	 * [ 정답 ]
	 * 원자들이 소멸되면서 방출하는 에너지의 총합을 구하기
	 * 
	 * [ 입력값 ]
	 * 원자들의 수 N, N개의 줄에는 원자들의 x위치, y위치, 이동 방향, 보유 에너지 K 
	 * 
	 * [ 풀이방법 ]
	 * 시간이 1초씩 지날 때마다, 이동방향으로 1씩 움직인다.
	 * -> 중복으로 가는 걸 막기 위해서, 0.5초씩 인덱스 관리
	 * -> N개 이상 만나면 다 사라지기 때문에 바로 소멸시키면 안됨
	 * => 이동을 하고, 그 후 중복되는 거 있으면 거길 소멸시켜야됨
	 * 
	 * 
	 * 1. 클래스 배열을 만든다
	 * 2. 계속해서 배열을 돌면서 좌표를 이동시킨다
	 * 	- 값이 -2000, 2000을 넘으면 스킵한다
	 *  - 혹시 하나라도 안 넘는 게 있으면 isDone을 false처리 해준다(true면 다 돈 거)
	 * 3. List를 돌면서 Dead가 아니라면, map에서 격자를 이동시켜서 확인
	 *
	 * [ 고려사항 ]
	 * 	- 영원히 충돌하지 않는 원자들을 어떻게 구분할 것인가?
	 * 	=> 2000*2000 벗어나면 소멸
	 * 
	 * 
	 * 
	 */

    // 상 하 좌 우 => r,y가 아니라 x,y좌표계로 주어짐에 주의!!!!!!!!
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;

    static class Point {

        int r;
        int c;
        int direction;
        int energy;
        boolean isDead;

        public Point(int r, int c, int direction, int energy) {
            this.r = r;
            this.c = c;
            this.direction = direction; // 0123 -> 상하좌우
            this.energy = energy;
            isDead = false;
        }
    }

    static Point[] arr;
    static int[][] map; // 실제 지도

    static int answer;

	public static void main(String[] args) throws Exception{
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            arr = new Point[N];
            map = new int[4001][4001]; // -2000~2000, 1도 포함돼서 4001
            answer = 0;


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                // 좌표 -> .5를 계산하기 위해서 *2만큼 이동해줌
                int x = (Integer.parseInt(st.nextToken())+1000) * 2;
                int y = (Integer.parseInt(st.nextToken())+1000) * 2;
                int direction = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());

                arr[i] = new Point(y , x, direction, energy);
            }

            boolean isDone = true;

            while(isDone) {
                isDone = false; // 모두가 isDead라면 isDone은 false로 유지됨
                // 리스트의 좌표 옮겨주기
                for (int i = 0; i < N; i++) {
                    Point p = arr[i];
                    if (p.isDead) {
                        continue;
                    }

                    isDone = true;
                    int nextR = p.r + dr[p.direction];
                    int nextC = p.c + dc[p.direction];

                    if (nextR < 0 || nextC < 0 || nextR > 4000 || nextC > 4000) {
                        p.isDead = true;
                        continue;
                    }

                    p.r = nextR;
                    p.c = nextC;
                    map[p.r][p.c]++; // 밟은 칸 표시
                }

                // 충돌 판정
                for (int i = 0; i < N; i++) {
                    Point p = arr[i];
                    if (map[p.r][p.c] > 1) {
                        // 충돌난 경우
                        p.isDead = true;
                        answer += p.energy;
                    }
                }

                // isDead 여부 상관없이 좌표값 리셋
                for (int i = 0; i < N; i++) {
                    Point p = arr[i];
                    map[p.r][p.c] = 0;
                }

            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");

			
		}

        System.out.println(sb);
		
		

	}

}
