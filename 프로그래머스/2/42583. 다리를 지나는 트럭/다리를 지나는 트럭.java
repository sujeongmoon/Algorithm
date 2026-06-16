import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸리는 시간
        
        
        // bridge_length만큼의 초가 필요하다. 

        // 만약 새로운 트럭을 추가하려할 때 무게가 초과하게 된다면, 잔여 시간만큼 answer를 더해서 트럭을 빼야함 (병목)
        // 처음에 큐에 넣을 때 트럭 무게랑, 내가 해당 다리에 들어간 시간을 함께 넣는다.
        
        // 만약에 현재 시간이 peek() + 경과시간이랑 똑같아도 큐에서 가장 최근 트럭 빼야함
        
        // a. 만약 다음 번에 들어갈 수 있는 경우
            // 그냥 새로 큐에 넣고, 총 무게 더하고, 시간 넣고
        
        // b. 못 들어가는 경우 -> 최근 트럭 빼야 함
            // peek() + 경과시간에 도달할 수 있도록 시간을 돌리고 빼고, 그 후 새로 큐에 너는 방식..
            // 이거는 계속해서 초과상태일 수 있으므로 반복문으로 짜야 함
            // 더했을 때 넘지 않을 때까지 추가
        
        ArrayDeque<Integer> wait = new ArrayDeque<>(); // 기다리는 중인 큐
        for (int t : truck_weights) {
            wait.offer(t);
        }
        
        ArrayDeque<int[]> bridge = new ArrayDeque<>(); // {무게, 현재 초}
        int nowWeight = 0;
        int nowTime = 1;
        
        while (!wait.isEmpty()){
            
            // 시간이 다 돼서 먼저 빠지는 경우
            if(!bridge.isEmpty()) {
                int[] peekTruck = bridge.peek();
                if (nowTime == peekTruck[1] + bridge_length) {
                    nowWeight -= peekTruck[0];
                    bridge.poll();
                }
            }
            
            
            int truck = wait.poll();
            
            // 못 들어가는 경우
            if (nowWeight + truck > weight) {
                while (nowWeight + truck > weight){
                    int[] outTruck = bridge.poll();
                    nowWeight -= outTruck[0];
                    nowTime = outTruck[1] + bridge_length;
                    
                }
            }
            
            // 들어가는 경우
            bridge.offer(new int[] {truck, nowTime});
            nowWeight += truck;
            nowTime++;
            
        }
        
        // bridge에 남아있는 시간 전부 빼야함
        while (!bridge.isEmpty()) {
            int[] lastTruck = bridge.poll();
            answer = lastTruck[1] + bridge_length;
        }
        
        return answer;
    }
}