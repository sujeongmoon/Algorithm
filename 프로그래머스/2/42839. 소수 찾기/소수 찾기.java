import java.util.HashSet;

class Solution {
    private HashSet<Integer> primes;

    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        boolean[] used = new boolean[arr.length];
        primes = new HashSet<>();

        dfs(arr, used, 0); // cur=0부터 시작, 한 자리씩 확장
        return primes.size();
    }

    private void dfs(char[] arr, boolean[] used, int cur) {
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            int next = cur * 10 + (arr[i] - '0');

            if (isPrime(next)) primes.add(next);

            dfs(arr, used, next);

            used[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if ((n & 1) == 0) return false; // 짝수 거르기

        int r = (int) Math.sqrt(n);
        for (int d = 3; d <= r; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
