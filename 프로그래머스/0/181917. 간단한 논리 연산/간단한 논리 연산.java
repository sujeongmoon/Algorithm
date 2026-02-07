class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        
        answer = kyo(hap(x1,x2), hap(x3,x4));
        
        return answer;
    }
    
    private boolean hap(boolean x1, boolean x2) {
        if (x1 || x2) {
            return true;
        }
        return false;
    }
    
    private boolean kyo(boolean x1, boolean x2) {
        if (x1 && x2) {
            return true;
        }
        return false;
    }
}