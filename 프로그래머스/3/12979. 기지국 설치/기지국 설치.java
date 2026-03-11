class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1; // 현재 전파를 확인해야 할 아파트 위치
        int range = 2 * w + 1; // 한 기지국이 커버하는 총 범위

        for (int station : stations) {
            // 1. 현재 위치(now)가 기지국의 전파 범위(station - w)보다 앞에 있다면
            if (now < station - w) {
                int gap = (station - w) - now; // 빈 구간의 길이
                
                // 빈 구간을 채우기 위해 필요한 기지국 수 계산 (올림)
                answer += gap / range;
                if (gap % range != 0) answer++;
            }
            // 2. 현재 위치를 해당 기지국 전파 범위 바로 다음으로 이동
            now = station + w + 1;
        }

        // 3. 마지막 기지국 이후에 남은 아파트들이 있는 경우
        if (now <= n) {
            int gap = n - now + 1;
            answer += gap / range;
            if (gap % range != 0) answer++;
        }

        return answer;
    }
}