import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        HashMap<String, String> recordHashMap = new HashMap<>();
        Queue<String[][]> orderQueue = new ArrayDeque<>();
        
        String[] parts = new String[3];
        String msg = "";
        String id = "";
        String name = "";
        
        for (String r : record) {
            
            parts = r.split(" ");
            msg = parts[0];
            id = parts[1];
            
            
            if (msg.equals("Enter")) {
                name = parts[2];
                if ((recordHashMap.containsKey(id) && !recordHashMap.get(id).equals(name))
                    || !recordHashMap.containsKey(id)) {
                    recordHashMap.put(id, name);
                }

            } else if (msg.equals("Change")) {
                name = parts[2];
                recordHashMap.put(id, name);
                continue;
            } 
            
            orderQueue.add(new String[][] {{msg, id}});
        }
        
        int length = orderQueue.size();
        
        for (int i = 0; i < length; i++) {
            String[][] order = orderQueue.poll();
            
            if (order[0][0].equals("Enter")) {
                answer.add(recordHashMap.get(order[0][1]) + "님이 들어왔습니다.");
            } else if (order[0][0].equals("Leave")) {
                answer.add(recordHashMap.get(order[0][1]) + "님이 나갔습니다.");
            }
            
        }
        
        
        return answer.toArray(new String[answer.size()]);
    }
}