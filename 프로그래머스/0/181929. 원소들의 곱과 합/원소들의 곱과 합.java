class Solution {
    public int solution(int[] num_list) {
        
        int mul = 1;
        int sumpwr = 0;
        
        for (int num : num_list) {
            mul *= num;
            sumpwr += num;
        }
        
        sumpwr *= sumpwr;
        
        if (mul < sumpwr) {
            return 1;
        } else {
            return 0;
        }
        
    }
}