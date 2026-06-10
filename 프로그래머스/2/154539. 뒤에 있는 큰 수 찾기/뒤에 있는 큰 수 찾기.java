import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            
            // 스택이 비어있지 않고, 현재 숫자(numbers[i])가 스택 맨 위 인덱스의 숫자보다 크다면?
            // -> 스택에 있는 인덱스의 뒷 큰수를 찾은 것이므로 만족하는 동안 계속 꺼냅니다.
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop(); // 뒷 큰수를 찾은 인덱스를 꺼냄
                answer[index] = numbers[i]; // 정답 배열에 현재 숫자를 기록
            }
            
            // 현재 인덱스를 스택에 푸시 (다음 숫자들과 비교하기 위함)
            stack.push(i);
        }
        
        
        return answer;
    }
}