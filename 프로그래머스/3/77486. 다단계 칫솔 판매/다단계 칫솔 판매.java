import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // enroll : 각 판매원의 이름, 루트노드(민호/center 제외)
        // referral : 각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름 (enroll에서 해당 위치의 부모임, 루트 자식이면 -)
        // seller : 판매량 집계 데이터의 판매원 이름을 나열한 배열 // i번째 판매량 집계 데이터 판 사람
        // amount: 판매량 집계 데이터의 판매 수량을 나열한 배열 // i번째 판매량 얼마 팔았는지 (판매수량*100이 번 금액)
        
        //return : 각 판매원이 얻은 이익금을 나열한 배열
        // -> 판매원에게 배분된 이익금의 총합을 계산해서, 입력으로 주어진 enroll에 따라서 나열.
        
        HashMap<String, Integer> reward = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            reward.put(enroll[i], 0);
            parent.put(enroll[i], referral[i]);

        }
        
        int price = 0;
        String rewarder = "";
        
        for (int i = 0; i < seller.length; i++) {
            price = amount[i]*100;
            rewarder = seller[i];
            while (price >= 10 && !rewarder.equals("-")) {

                // reward.put(rewarder, reward.get(seller[i])+price-(price/10));
                reward.put(rewarder, reward.get(rewarder)+price-(price/10));
                price /= 10;
                rewarder = parent.get(rewarder);
            }
            if (!rewarder.equals("-")) {
                reward.put(rewarder, reward.get(rewarder)+price);
            }
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = reward.get(enroll[i]);
        }
        
        
        return answer;
    }
    
    
    
}