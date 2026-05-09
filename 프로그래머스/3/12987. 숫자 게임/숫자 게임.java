import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // A팀의 순서를 보고 자신들의 최종 승점을 가장 높였을 때의 최종 점수
        // A팀보다 이겨야함
        // 즉, A팀의 순서에서 그것보다 가장 조금만 큰 수로 정해야함
        // 근데 해당 결과가 뒤에 영향을 미치기 때문에... 
        // 없는 경우에는, 가장 작은 숫자를 넣으면 됨
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        
        while (bIdx < B.length) {
            if (A[aIdx] < B[bIdx]) { // B가 이기는 경우
                answer++;
                aIdx++; // A도 다음 사람
            }
            bIdx++; // B는 이기든 지든 다음 카드
        }
        
        return answer;
    }
}