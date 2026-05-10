class Solution {
    public long solution(int n) {
        
        // 경우의수 > dp 고려
        
        // n이 1일때는 하나고
        // n이 2일때는 1칸, 2칸인지 아님녀 2칸 한번에 갈 건지라 두 개
        // n이 3일 때에는 -> 한한한, 한두, 두한 이라서 세 개
        // n이 4일 때에는 -> 한한한한, 한두한, 한한두, 두한한, 두두 -> 5개
        // n이 5일 때에는 -> 1. 한으로 고정한 경우 -> 4이다. + 2. 두로 고정한 경우 -> 3이다. 그럼 여덟개? 즉, n-1이랑 n-2를 더한거
        
        int[] array = new int[n+1];
        
        array[0] = 1;
        array[1] = 1;
        
        for (int i = 2; i < n+1; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1234567;
        }
        
        return array[n];
    }
}