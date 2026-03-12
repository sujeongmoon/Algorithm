class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        // DFS 시작: (0번째 인덱스부터, 현재 합계는 0)
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        // 1. 탈출 조건: 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 2. 수행 동작: 현재 숫자를 더하거나 빼거나 (두 갈래 길)
        dfs(numbers, target, index + 1, sum + numbers[index]); // 더하는 경우
        dfs(numbers, target, index + 1, sum - numbers[index]); // 빼는 경우
    }
}