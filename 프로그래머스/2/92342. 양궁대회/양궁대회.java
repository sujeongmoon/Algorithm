import java.util.*;

class Solution {
    
    int[] INFO;
    int N;
    
    int[] lionVisited = new int[11];
    int[] maxVisited = new int[11];
    
    int maxDiff;
    
    private boolean isMaxDiff() {
        for (int i = 10; i >= 0; i--) {
            if (lionVisited[i] > maxVisited[i]) {
                return true;
            } else if (lionVisited[i] < maxVisited[i]) {
                return false;
            }
        }
        return false;
    }
    
    
    private void dfs(int i, int remain) {
        
        if (i == 11) { // 마지막까지 간 경우 다 0으로 몰아주기
            lionVisited[10] += remain;
            // 점수 계산 필요
            // for로 돌리면서 apeach와 lion 점수를 지역변수로 설정해서 계산
            int apeachScore = 0;
            int lionScore = 0;
            
            for (int j = 0; j < 11; j++) {
                if (INFO[j] == 0 && lionVisited[j] == 0) { // 무승부는 다 0점
                    continue;
                }
                
                if (INFO[j] >= lionVisited[j]) {
                    apeachScore += (10 - j);
                } else {
                    lionScore += (10 - j);
                }
            }
            
            int diff = lionScore - apeachScore;
            
            // // 차가 0 이하라면 실패, lionVisited[10] -= remain 후 리턴 : 불필요
            // if (diff <= 0) {
            //     lionVisited[10] -= remain;
            //     return;
            // }
            
            // 차가 maxDiff보다 크면 maxDiff, maxVisited값을 갱신해야함. 
            if (diff > maxDiff) {
                maxDiff = diff;
                maxVisited = lionVisited.clone();
            }
            
            // 차가 maxDiff와 같다면 가장 낮은 점수부터 비교해서, 더 많이 맞힌 경우를 max값으로 선정
            if (diff == maxDiff) {
                if(isMaxDiff()) {
                    maxDiff = diff;
                    maxVisited = lionVisited.clone();
                }
            }
                
            // 롤백 후 리턴
            lionVisited[10] -= remain;
            return;
        
        }
        
        // 1. 해당 점수를 라이언이 갖는 경우
        int need = INFO[i] + 1;
        if (need <= remain) { // 갈 수 있는 경우에만 가도록
            lionVisited[i] = need;
            dfs(i+1, remain - need);
        }

        // 2. 해당 점수를 라이언이 안 갖는 경우
        lionVisited[i] = 0;
        dfs(i+1, remain);

    }
    
    public int[] solution(int n, int[] info) {
        
        // info, N 전역변수화
        N = n; 
        INFO = info;
        
        dfs(0, n);
        
        // maxDiff가 0이라면 [-1] 리턴, 아니면 maxScore 리턴
        if (maxDiff == 0) {
            return new int[] {-1};
        }
        return maxVisited;
    }
} 