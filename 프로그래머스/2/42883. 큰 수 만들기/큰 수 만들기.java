import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        // O(n)으로 해결하기
        
        // 무조건 앞자리가 제일 큰 수여야 좋을 것 같은데.. 이건 너무 지엽적인 접근 같고
        // 이걸 넣냐빼냐? 를 봐야되겠지
        
        // 처음부터 돌면서, 앞이랑 뒤랑 비교했을 때, 뒤가 앞보다 크면 앞을 뺌
        // 앞에 나온 모든 숫자가 자기보다 작으면, 다 빼야함
        
        // 스택!!!
        // 일단 수를 스택 안에다가 넣고, 만약에 빼냈을 때 그게 자기보다 작다면, 그건 빼는 거임. 아니면 그냥 스택에다가 넣고
        // 그걸 k 가 0이 될 때까지
        
        StringBuilder sb = new StringBuilder(); // sb를 스택처럼 사용해보자
        //ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < number.length(); i++) {
            
            char c = number.charAt(i); // 현재 보고있는 number
            
            // 빼기, 스택이 비면 끝, k가 0보다 작아지면 끝
            // 스택이 비지 않았고 k가 0보다 큰 상황에서만 반복
            while((sb.length() != 0) && (k > 0)) {
                
                // sb의 가장 끝(스택)이 현재 보고있는 c보다 작다면, 해당 수를 꺼내야함, 계속해서
                if(sb.charAt(sb.length()-1) < c) {
                    sb.setLength(sb.length()-1);
                    k--;
                } else { // 작지 않다면 패스
                    break;
                }
            }
            
            // 지금 수를 sb에다가 추가
            sb.append(c);
            
        }
        
        // 스택을 다 보내고 k가 남았다면, 남은만큼 맨 뒤를 빼내기. 
        if (k > 0) {
            sb.setLength(sb.length() - k);
        }
        

        return sb.toString();
    }
}