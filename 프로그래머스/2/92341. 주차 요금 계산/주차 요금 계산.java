import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        
        // 출차 내역이 없다면 23:59에 출차된 것
        // 차량별 누적 주차 시간 계산하여 요금 일괄로 정산
        
        // 기본시간 / 초과한 시간에 대해서 단위시간마다 단위요금 청구
        // 올림
        
        
        // fees [ 기본시간, 기본 요금, 단위 시간, 단위 요금]
        // records 시각 차량번호 내역
        // HH:MM, 길이4문자열, IN or OUT
        
        StringTokenizer st;
        
        HashMap<String, String> parkingLot = new HashMap<>(); // 주차장 - 차량번호, 입차시간
        HashMap<String, Integer> sumTime = new HashMap<>(); // 누적시간 - 차량번호, 누적시간
        
        for (int i = 0; i < records.length; i++) {
            
            st = new StringTokenizer(records[i]);
            
            String time = st.nextToken();
            String carNum = st.nextToken();
            
            if (st.nextToken().equals("IN")) {
                // 입차 시 기록
                parkingLot.put(carNum, time);
                
            } else {
                // 출차 시 기록
                String beforeTime = parkingLot.get(carNum);
                parkingLot.remove(carNum);
                
                StringTokenizer nowSt = new StringTokenizer(time, ":");
                StringTokenizer beforeSt = new StringTokenizer(beforeTime, ":");
                
                int hour = Integer.parseInt(nowSt.nextToken()) - Integer.parseInt(beforeSt.nextToken());
                int min = Integer.parseInt(nowSt.nextToken()) - Integer.parseInt(beforeSt.nextToken());
                
                sumTime.put(carNum, sumTime.getOrDefault(carNum, 0) + (hour * 60) + min); // 누적합 시간 더하기
                
            }
            
        }
        
        // parkingLot 돌면서 23:59로 출차시키기
        
        for (Map.Entry<String, String> entry : parkingLot.entrySet()) {
            
            String carNum = entry.getKey();
            String beforeTime = parkingLot.get(carNum);
            
            StringTokenizer beforeSt = new StringTokenizer(beforeTime, ":");
                
            int hour = 23 - Integer.parseInt(beforeSt.nextToken());
            int min = 59 - Integer.parseInt(beforeSt.nextToken());
                
            sumTime.put(carNum, sumTime.getOrDefault(carNum, 0) + (hour * 60) + min); // 누적합 시간 더하기
            
        }
        
        // int[] answer = sumTime.entrySet().stream()
        //     .sorted(Map.Entry.comparingByKey())
        //     .mapToInt(Map.Entry::getValue)
        //     .toArray();
        
        int[] answer = sumTime.entrySet().stream()
            .sorted((o1, o2) -> {
                return o1.getKey().compareTo(o2.getKey());
            }).mapToInt(Map.Entry::getValue)
            .toArray();
         
        for (int i = 0; i < answer.length; i++) {
            
            int time = answer[i];
            int fee = fees[1];
            int temp = 0;
            
            if (time > fees[0]) {
                time -= fees[0];
                
                temp = time / fees[2];
                if (time % fees[2] > 0) {
                    temp++;
                }
                
                fee += temp * fees[3];
                
            }
            
            answer[i] = fee;
            
        }
        
        
        return answer;
    }
}