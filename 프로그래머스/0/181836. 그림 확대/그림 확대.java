class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
    
        // StringBuilder 사용
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < picture.length; i++) {
     
            for (int l = 0; l < picture[i].length(); l++) {
                for (int m = 0; m < k; m++) {
                    // append, charAt 통해 추가
                    word.append(picture[i].charAt(l));
                }                 
            }
            
            for (int j = 0; j < k; j++) {
                // i*k+j
                answer[i*k+j] = word.toString();
            }
            // word.length()로 채워져있는 word를 다 지우기
            word.delete(0, word.length());  
        }
        
        
        return answer;
    }
}