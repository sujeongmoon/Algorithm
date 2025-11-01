import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());       
       
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
            
            int[] parkPriceArray = new int[n+1];
            
            for (int j = 1; j <= n; j++) { // parkPriceArray[j] 생성
            	parkPriceArray[j] = Integer.parseInt(br.readLine());
            }
            
           int[] carWeightArray = new int[m+1];
            
           for (int j = 1; j <= m; j++) {
               carWeightArray[j] = Integer.parseInt(br.readLine());
           }
            PriorityQueue<Integer> parkingLot = new PriorityQueue<>();
            for (int j = n; j > 0; j--) {
            	parkingLot.add(j);
            }
            ArrayDeque<Integer> waitCarQueue = new ArrayDeque<>();
            HashMap<Integer, Integer> carParkingLotMap = new HashMap<>(); // 차량, 주차장위치
            
                      
            for (int j = 1; j <= 2*m; j++) {
                // 차 들어오고 나가기 시작
            	int car = Integer.parseInt(br.readLine());
            	int spaceNumber = 0;
                
                if (car > 0) {
                    if (parkingLot.isEmpty()) {
                        waitCarQueue.add(car);                
                    } else{
                        spaceNumber = parkingLot.poll();
                        answer += carWeightArray[car] * parkPriceArray[spaceNumber];
                        carParkingLotMap.put(car, spaceNumber);
                    }   
                } else {
                    spaceNumber = carParkingLotMap.get(car*-1);
                    if (!waitCarQueue.isEmpty()) {
                        car = waitCarQueue.poll(); 
                        answer += carWeightArray[car] * parkPriceArray[spaceNumber];
                        carParkingLotMap.put(car, spaceNumber);
                    } else {
                        parkingLot.add(spaceNumber);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(test_case).append(' ');
            sb.append(answer).append('\n');
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
	}
}