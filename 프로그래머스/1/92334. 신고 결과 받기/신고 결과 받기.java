import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        
        HashMap<String, Integer> idIndexMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
            
            reportMap.put(id_list[i], new HashSet<String>());
        }
        
        for (String content: report) {
            
            String[] contentArray = content.split(" ");
            
            String reporter = contentArray[0];
            String reported = contentArray[1];

            reportMap.get(reported).add(reporter);
            
        }
        
        for (int i = 0; i < id_list.length; i++) {
            if (reportMap.get(id_list[i]).size() >= k) {
                ArrayList<String> reporterList = new ArrayList<>(reportMap.get(id_list[i]));
                for (int j = 0; j < reporterList.size(); j++) {
                    answer[idIndexMap.get(reporterList.get(j))]++;
                }    
            }
        }

        return answer;
    }
}