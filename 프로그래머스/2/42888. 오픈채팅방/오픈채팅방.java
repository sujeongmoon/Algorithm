import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>(); // id - nickname
        
        // 맵 완성
        for (int i = 0; i < record.length; i++) {
           StringTokenizer st = new StringTokenizer(record[i]);
            
            String notice = st.nextToken();
            
            // enter과 change인 경우 map 업데이트해서 id-nickname 업데이트
            if (notice.equals("Enter") || notice.equals("Change")) {
                String userId = st.nextToken();
                String userNickName = st.nextToken();
                
                map.put(userId, userNickName);
            }  
        }
        
        // 공지 채우기
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String notice = st.nextToken();
            if (notice.equals("Change")) {
                continue;
            }
            String userId = st.nextToken();
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(userId));
            if (notice.equals("Enter")) {
                sb.append("님이 들어왔습니다.");
            } else if (notice.equals("Leave")) {
                sb.append("님이 나갔습니다.");
            } 
            list.add(sb.toString());
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}