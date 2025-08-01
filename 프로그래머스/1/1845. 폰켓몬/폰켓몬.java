import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int capablePonkemon = nums.length/2;
        
        HashSet<Integer> ponkemonSet = new HashSet<>();
        for (int i : nums) {
            ponkemonSet.add(i);
        }
        
        if (ponkemonSet.size() >= capablePonkemon) {
            return capablePonkemon;
        } else {
            return ponkemonSet.size();
        }
        
    }
}