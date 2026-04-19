import java.util.*;

class Solution {   
    
    public static HashMap<Integer, int[]> picksMap = new HashMap<>();
    public static int answer = Integer.MAX_VALUE;
    public static int totalPicks = 0;
    public static String[] staticMinerals;
    
    public int solution(int[] picks, String[] minerals) { // 곡괭이의 개수 배열, 광물들의 순서
        
        staticMinerals = minerals;
        picksMap.put(0, new int[] {1, 1, 1});
        picksMap.put(1, new int[] {5, 1, 1});
        picksMap.put(2, new int[] {25, 5, 1});

        // 전체 경우의 수를 다 만들어 본 다음, 최솟값 구하는 방식으로
        // -> picks를 하나씩 줄여가는 방식으로
        
        // 여기서 answer 구해준다
        for (int i = 0; i < picks.length; i++) {
            totalPicks += picks[i];
        }
        
        backtracking(picks, 0, 0, 0);
        
        return answer;
    }
    
    public static void backtracking(int[] picks, int count, int idx, int past) { // 현재 남아있는 곡괭이 배열, 현재까지 쓴 곡괭이 개수, 봐야 할 minerals의 인덱스, 현재까지의 피로도
        
        // 종료조건: 더이상 사용할 곡괭이가 없는 경우나, 현재까지 캔 광물 수가 minerals의 끝과 동일할 경우
        if (idx >= staticMinerals.length || count == totalPicks) {
            answer = Math.min(answer, past);
            return;
        }
        
        int mineral = -1;
        int now;
        
        // 만약 배열이 미리 끝났다면 다음 인덱스로 넘겨주기
        for (int i = 0; i < 3; i++) {
            
            if (picks[i] <= 0) {
                continue;
            }
            
            now = past;
            
            for (int j = idx; j < idx+5; j++) {
                if (j == staticMinerals.length) {
                    break;
                }
                
                if (staticMinerals[j].equals("diamond")) {
                    mineral = 0;
                } else if (staticMinerals[j].equals("iron")) {
                    mineral = 1;
                } else if (staticMinerals[j]. equals("stone")) {
                    mineral = 2;
                }
                
                // now에 값 더해주기
                now += picksMap.get(i)[mineral];
                
            }
            
            picks[i]--;
            backtracking(picks, count + 1, idx + 5, now);
            picks[i]++;

            }
        
    }
    
}