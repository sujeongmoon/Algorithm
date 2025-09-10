import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 일정한 금액을 지불하면 10일동안 회원 자격을 부여한다.
        // 그 회원 대상으로 -> 매일 한 가지 제품을 할인한다. => 하루에 하나씩만 구매할 수 있다.
        
        // 내가 원하는 제품이랑, 수량이, 할인하는 날짜와 "10일 연속으로 일치할 경우"에 맞춰서 회원가입하고싶어.
        // 회원등록 날짜의 총 일수를 리턴.
        
        // 총 10일을 원하는 것이기 때문에, number의 원소의 합은 10이 됨. (총 수량은 10개)
        // discount의 길이는 100000 -> 이 중에서 10개가 내가 원하는 게 있을 때, +1을 해야하는 것.
        // 100000개나 된다하면... O(n)에서 되어야 할 것 같음.
        // -> 순서대로 하는 건 아니니까 큐는 아니고, 스택도 아니고, 그럼 해시..라는 사고방식을 가져야 하나?
        
        //일단, for문을 10개로 끊어서... 음. 하, 어쩔 수 없이 10개는 가야하는 것 아닌가...
        
        HashMap<String, Integer> wantHashMap = new HashMap<>();       
        for (int i = 0; i < want.length; i++) {
            wantHashMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> compareWantHashMap = new HashMap<>();
        boolean flag = true;
        
        for (int i = 0; i < discount.length - 9; i++) {
            compareWantHashMap.putAll(wantHashMap);
            for (int j = 0; j < 10; j++) {
                if (compareWantHashMap.containsKey(discount[i+j]) && compareWantHashMap.get(discount[i+j]) != 0) {
                    compareWantHashMap.put(discount[i+j], compareWantHashMap.get(discount[i+j])-1);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
            flag = true;
        } 
        
        
        
        return answer;
    }
}