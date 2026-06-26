class Solution {
    
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    static void dfs(int index, int sum, int[] numbers, int target) {
        
        // 종료조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // 더해서 다음으로
        dfs(index+1, sum+numbers[index], numbers, target);
        
        // 빼서 다음으로
        dfs(index+1, sum-numbers[index], numbers, target);
        
    }
}