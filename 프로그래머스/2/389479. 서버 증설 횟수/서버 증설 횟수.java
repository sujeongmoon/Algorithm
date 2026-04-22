class Solution {
    public int solution(int[] players, int m, int k) { 
        // players 이용자의 수 (length 24), 
        // m 서버 1대가 감당 가능한 최대 이용자 수, 
        // k 서버 한 대가 운영 가능한 시간
        
        int answer = 0; // 서버 증설 횟수
        
        // m명 늘어날 때마다 서버 1대가 필요.
        // 서버 증설하면 k시간 동안 운영하고 그 이후는 반납
        // 서버를 최소 몇 번 증설해야 하는지
        
        
        // 이용자는 1000명 이하 
        
        // 현재 운용중인 서버 개수 nowServer
        // 그냥 간단하게 현재 + k까지 돌면서 m씩 빼고, 만약 양수인 경우 0이나 음수와 같을 때까지 계속 빼고 answer +하면 될 듯
        
        for (int i = 0; i < 24; i++) {
            
            if (players[i] >= m) {
                while (players[i] >= m) {
                    for (int j = i; (j < i+k && j < 24); j++) {
                        players[j] -= m;
                    }
                    answer++;
                    System.out.println(i);
                }
            }
            
        }
        
        
        
        return answer;
    }
}