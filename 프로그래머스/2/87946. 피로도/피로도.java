class Solution {
    static int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        maxDungeons = 0;
        
        // 1이상 8 이하니까 하나하나 다 해보기.
        boolean[] isVisited = new boolean[dungeons.length];
        backtracking(k, 0, dungeons, isVisited);
        
        return maxDungeons;
    }
    
    public static void backtracking(int currentK, int depth, int[][] dungeons, boolean[] isVisited) {
        maxDungeons = Math.max(maxDungeons, depth); // 최대 깊이 갱신해주기
        
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 안 갔고, 현재 피로도가 최소 필요 피로도 이상일 때에만 간다
            if (!isVisited[i] && currentK >= dungeons[i][0]) {
                isVisited[i] = true;
                backtracking(currentK - dungeons[i][1], depth + 1, dungeons, isVisited);
                isVisited[i] = false;
            }
        }
        
    }
}