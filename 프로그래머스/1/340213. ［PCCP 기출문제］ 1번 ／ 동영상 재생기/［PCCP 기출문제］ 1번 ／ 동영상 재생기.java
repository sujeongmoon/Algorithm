import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    
        StringTokenizer st = new StringTokenizer(video_len, ":");
        
        int video_len_sec = stringToSec(video_len);
        int pos_sec = stringToSec(pos);
        int op_start_sec = stringToSec(op_start);
        int op_end_sec = stringToSec(op_end);
        
        int now_sec = pos_sec;
        
        // 동영상 재생기. 10초전/10초후/오프닝 건너뛰기
        
        for (int i = 0; i < commands.length; i++) {
            
            String command = commands[i];
            System.out.println(now_sec/60 + ":" + now_sec%60);
            
            if (now_sec >= op_start_sec && now_sec <= op_end_sec) {
                   now_sec = op_end_sec;
                }
            
            if (command.equals("next")) {
                now_sec += 10;
                if (now_sec >= video_len_sec) {
                    now_sec = video_len_sec;
                }
            } else if (command.equals("prev")) {
                now_sec -= 10;
                if (now_sec <= 10) {
                    now_sec = 0;
                }
            } 
            
            if (now_sec >= op_start_sec && now_sec <= op_end_sec) {
                   now_sec = op_end_sec;
                }
        }
        
        String min = now_sec/60 >= 10 ? Integer.toString(now_sec/60) : "0"+Integer.toString(now_sec/60);
        String sec = now_sec%60 >= 10 ? Integer.toString(now_sec%60) : "0"+Integer.toString(now_sec%60);
        
        return min+":"+sec;
    }
    
    public int stringToSec(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        
        return min*60 + sec;
    }
}