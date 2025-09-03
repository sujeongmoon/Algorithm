import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < moves.length; i++) {
            int j = 0;
            
            // j의 마지막 인덱스나 / 인형이 있는 row까지 j++
            while (board[j][moves[i]-1] == 0 && j!=board.length - 1) {
                j++;
            }
            
            // 아무 것도 안 들어있는 경우엔 아무 일도 일어나지 않아야함
            // 스택이 비어있는 경우+ 인형이 안 들어있는 경우에도 아무 일도 일어나지 않아야 함
            // 스택이 차있는 경우 + 인형이 안 안 들어있는 경우에도 아무 일도 일어나지 않아야 함
            // 스택을 채워야하는 경우 -> 값이 있을 때
            
            if (board[j][moves[i]-1]!= 0) {
                
                // 캐릭터가 무조건 들어있는 상황
                // 스택에 넣어야하는 경우 -> peek으로 비교해봤을 때 기존이랑 다를 때 || stack이 비어있을때
                // 스택에서 pop해야하는 경우 -> peek으로 비교해봤을 때 기존이랑 같을 때
                if (!stack.isEmpty() && stack.peek() == board[j][moves[i]-1]) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(board[j][moves[i]-1]);
                }
            } else {
                continue;
            }
            board[j][moves[i]-1] = 0;
        }
        
        return answer;
    }
}