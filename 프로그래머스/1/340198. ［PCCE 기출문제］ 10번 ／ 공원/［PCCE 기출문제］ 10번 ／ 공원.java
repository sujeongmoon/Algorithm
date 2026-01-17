import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int max = 0;
        
        // mats 내림차순 정렬
        Arrays.sort(mats);
        for (int i = 0; i < mats.length/2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }
        
        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (park[i][j].equals("-1") && i+mat <= park.length && j+mat <= park[0].length) {
                        if (check(park, mat, i, j)) {
                            return mat;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static boolean check(String[][] park, int mat, int a, int b) {
       
        for (int i = a; i < a + mat; i++) {
            for (int j = b; j < b + mat; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}