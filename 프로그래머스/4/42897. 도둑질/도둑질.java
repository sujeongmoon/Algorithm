class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        
        int[] firstVisit = new int[money.length];
        
        firstVisit[0] = money[0];
        firstVisit[1] = money[0];
        
        for(int i = 2; i < money.length; i++) {
            firstVisit[i] = Math.max(firstVisit[i-1], firstVisit[i-2] + money[i]);
        }
        
        //
        int[] firstNotVisit = new int[money.length];
        
        firstNotVisit[0] = 0;
        firstNotVisit[1] = money[1];
        
        for(int i = 2; i < money.length; i++) {
            firstNotVisit[i] = Math.max(firstNotVisit[i-1], firstNotVisit[i-2] + money[i]);
        }
        
        // 원형이니까 첫번째 방문하는경우는 -2로해서 강제로 처음꺼 빼버리기
        return Math.max(firstVisit[firstVisit.length-2], firstNotVisit[firstVisit.length-1]);
    }
}