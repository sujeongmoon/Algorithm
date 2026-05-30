class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String change = Integer.toString(n, k);
        
        String[] changeSplit = change.split("0");
        
        for (String s : changeSplit) {
            if (s.isEmpty()) {
                continue;
            }
            if (isPrimeNumber(s)) {
                answer++;
            }
        }
        
        return answer;
        
    }
    
    public static boolean isPrimeNumber(String s) {
        long num = Long.parseLong(s);
        
        if (num < 2) {
            return false;
        }
        
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}