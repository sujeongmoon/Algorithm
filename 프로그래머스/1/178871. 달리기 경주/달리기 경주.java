import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>(); // 이름, 등수(인덱스) 저장
        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            // 등수를 찾음
            String winner = callings[i];
            int rank = map.get(winner); // 현재 앞으로 옮겨야하는 랭크(-1로옮겨야함)
            
            // players에서 해당 배열 변경-> 
            String loser = answer[rank-1];
            
            answer[rank-1] = winner;
            answer[rank] = loser;
            
            // map에서 value값 변경
            map.put(winner, rank-1);
            map.put(loser, rank);
        }
        
        return answer;
    }
}