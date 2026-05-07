class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // queries[2]보다 크면서 i는 [0]이랑 [1] 사이어야 함.
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int min = Integer.MAX_VALUE;
            
            for (int j = query[0]; j <= query[1]; j++) {
                if (arr[j] > query[2]) {
                    min = Math.min(arr[j], min);
                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            answer[i] = min;
        }
        
        return answer;
    }
}