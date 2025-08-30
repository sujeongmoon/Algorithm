import java.util.*;

class Solution {
    public int solution(String dirs) {

        // 기존의 x,y
        int x1 = 0;
        int y1 = 0;
        //새로운 x, y
        int x2 = 0;
        int y2 = 0;
        
        HashSet<String> dirSet = new HashSet<>();
       
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            
            x1 = x2;
            y1 = y2;
            
            if(dir == 'U' && y2 != 5) {
                y2++;
            } else if (dir == 'L' && x2 != -5) {
                x2--;
            } else if (dir == 'R' && x2 != 5) {
                x2++;
            } else if (dir == 'D' && y2!= -5) {
                y2--;
            }
            
            if (x1 == x2 && y1 == y2) continue;
            
            StringBuilder sb1 = new StringBuilder();
            sb1.append(x1);
            sb1.append(" ");
            sb1.append(y1);
            sb1.append(" ");
            sb1.append(x2);
            sb1.append(" ");
            sb1.append(y2);
            
            dirSet.add(sb1.toString());
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append(x2);
            sb2.append(" ");
            sb2.append(y2);
            sb2.append(" ");
            sb2.append(x1);
            sb2.append(" ");
            sb2.append(y1);
            
            dirSet.add(sb2.toString());
            
            // System.out.println(Arrays.toString(dirSet.stream().toArray()));
            // System.out.println(dirSet.size()/2);
            
            
        }
        
        // System.out.println(Arrays.toString(dirSet.stream().toArray()));
        
        return dirSet.size()/2;
    }
}