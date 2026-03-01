class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        int order = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (my_string.charAt(i) == 'A'+j) {
                    answer[j]++;
                    break;
                } 
            }
            for (int j = 26; j < 52; j++) {
                if (my_string.charAt(i) == 'a'+j-26 ) {
                    answer[j]++;
                    break;
                } 
            }
        }
        
        return answer;
    }
}