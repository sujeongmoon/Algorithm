import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        ArrayDeque<Integer> deleted = new ArrayDeque<>();
        
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;
        
        for (String c : cmd) {
            // 현재 위치 삭제 후 다음 위치로 이동
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                
                if (n < down[k]) {
                    k = up[k];
                } else {
                    k = down[k];
                } 
            // 가장 최근에 삭제된 행 복원
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
            
                for (int i = 0; i < x; i++) {
                    if (s[0].equals("U")) {
                        k = up[k];
                    } else {
                    k = down[k];
                    }
                }
                
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}
