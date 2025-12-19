class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        char alpC = alp.charAt(0);
        
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == alpC) {
                answer += String.valueOf(my_string.charAt(i)).toUpperCase();
            } else {
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}