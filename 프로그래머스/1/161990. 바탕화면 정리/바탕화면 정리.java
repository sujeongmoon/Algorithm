class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        boolean flag = false;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++ ) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        flag = false;
        
        
        for (int i = 0; i < wallpaper[0].length(); i++) {
            for(int j = 0; j < wallpaper.length; j++) {
                if (wallpaper[j].charAt(i) == '#'){
                    answer[1] = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }     
        }
        flag = false;
        
        
        
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            for (int j = wallpaper[0].length() - 1; j >= 0; j-- ) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[2] = i+1;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        flag = false;
        
        
        for (int i = wallpaper[0].length() - 1; i >= 0; i--) {
            for(int j = wallpaper.length - 1; j >= 0; j--) {
                if (wallpaper[j].charAt(i) == '#'){
                    answer[3] = i+1;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }     
        }
        flag = false;
        
        
        return answer;
    }
}