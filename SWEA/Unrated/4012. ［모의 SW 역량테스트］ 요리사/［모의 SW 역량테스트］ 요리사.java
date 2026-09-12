import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
class Solution
{
     static int N;
     static int[][] arr;
     static int answer;
     static List<Integer> aList;
     static List<Integer> bList;

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 식재료
            arr = new int[N][N];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2/N개로 나누어서 그 합??
            // 그럼 어케해?? A에 넣는 경우/ B에 넣는 경우를 따로 관리해야지
            //
            aList = new ArrayList<>();
            bList = new ArrayList<>();

            dfs(0, 0, 0);


            sb.append("#").append(t).append(" ").append(answer).append("\n");


        }

        System.out.println(sb.toString());
    }

    // 지금 다룰 요리 번호 개수, a 합, b합
    static void dfs(int count, int aSum, int bSum) {

        if (count == N) {
            int sum = Math.abs(aSum - bSum);
            answer = Math.min(answer, sum);
        }

        // count번째가 a로 들어간 경우
        if (aList.size() < N / 2) {
            int nextASum = aSum;
            for (int i = 0; i < aList.size(); i++) {
                nextASum += arr[aList.get(i)][count];
                nextASum += arr[count][aList.get(i)];

            }
            aList.add(count);
            dfs(count + 1, nextASum, bSum);
            aList.remove(aList.size() - 1);
        }

        // count번째가 b로 들어간 경우
        if (bList.size() < N / 2) {
            int nextBSum = bSum;
            for (int i = 0; i < bList.size(); i++) {
                nextBSum += arr[bList.get(i)][count];
                nextBSum += arr[count][bList.get(i)];

            }
            bList.add(count);
            dfs(count + 1, aSum, nextBSum);
            bList.remove(bList.size() - 1);
        }

    }
     
}