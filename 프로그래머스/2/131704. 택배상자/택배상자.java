import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 번호가 증가하는 순서대로 컨테이너 벨트에 일렬로 놓인다
        // 배달하는 순서로 바꿔야한다
        
        // 보조컨베이너벨트, 큐 형식
        // 원하는 순서대로 상자를 못 싣는다면 끝
        
        // answer : 몇 개의 상자를 실을 수 있는지.
        
        // order에서 큐가 끝나면 보조큐로 보냄. 보조큐는 스택
        
        
        // 4 3 1 2 5
        // 1 2 3 4 5
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = 0; // order의 인덱스
        for (int i = 1; i <= order.length; i++) {
            
            // 현재 값이 넣어야하는 값이랑 다르다면 stack에다가 전부 다 푸쉬
            if (i != order[idx]) {
                stack.push(i);
                continue;
            }
        
            // 같다면
            answer++;
            idx++;
            
            // 다를 때까지 stack 빼기
            
            while(!stack.isEmpty() && (stack.peek() == order[idx])) {
                // 넣어야한다면 넣어주고 idx++
                stack.pop();
                answer++;
                idx++;
            }
            
        }
        
        
        return answer;
    }
}