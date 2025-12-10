import java.util.*;

class Solution {
    
    private static int length;
    private static int answer;
    private static int[] Weak;
    private static boolean[] used;
    
    
    // 0, new int[i], org
    private static void backtrack(int n, int[] dist, int[] org) {
        // n개의 숫자를 나열하는 모든 경우의 수를 구함
        if (n == org.length) {
            // 모든 외벽이 점검 가능하면 답 저장
            if (check(dist))
                answer = n;
            return;
        }
        
        // 한 번 사용한 친구는 다시 사용하지 않도록 used 배열을 활용하여 백트래킹
        for (int i = 0; i < org.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dist[n] = org[i];
                backtrack(n + 1, dist, org);
                used[i] = false;
            }
        }
    }
    
    private static boolean check(int[] dist) {
        // dist 배열의 친구들로 모든 외벽이 점검 가능한지 확인
        for (int i = 0; i < length; i++) { 
            // 점검을 시작하는 외벽을 0부터 length까지 전부 확인함
            int idx = i;
            // 각 친구가 점검 가능한 외벽을 모두 점검하며 진행
            for (int distance : dist) {
                int position = Weak[idx++] + distance;
                while (idx < Weak.length && Weak[idx] <= position) {
                    idx++;
                }
            }
            
            if (idx - i >= length)
                return true;
        }
        return false;
    }
    
    
    public int solution(int n, int[] weak, int[] dist) {
        
        length = weak.length;
        Weak = new int[length * 2]; // 기존 weak의 두 배 배열 만들어주기
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                Weak[j + (i * length)] = weak[j] + (i * n);
                
            }
        }
        
        Arrays.sort(dist); // 친구들을 오름차순으로 정렬
        answer = -1;
        used = new boolean[dist.length]; // 친구 visited boolean 배열
        
        for (int i = 1; i <= dist.length; i++) {
            int[] org = new int[i];
            System.arraycopy(dist, dist.length - i, org, 0, i); // 부분복사. dist.length-i부터를 org의 0인덱스부터 복사하고, i만큼. 즉 dist.length[마지막-i]부터 끝까지 i만큼의 배열을 복사하는 거겠지?
            backtrack(0, new int[i], org);
            if (answer > 0) {
                break;
            }
        }
        
        
        return answer;
    }
}