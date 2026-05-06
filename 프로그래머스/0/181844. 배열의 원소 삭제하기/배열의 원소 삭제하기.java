import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> arrList = new ArrayList<>();
        HashSet<Integer> delete_set = new HashSet<>();
        for (int d : delete_list) {
            delete_set.add(d);
        }
        
        for (int a : arr) {
            if (!delete_set.contains(a)) {
                arrList.add(a);
            }
        }
        
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}