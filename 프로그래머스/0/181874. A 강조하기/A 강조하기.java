class Solution {
    public String solution(String myString) {
        String answer = "";
        
        char[] myStringCharArr = myString.toCharArray();
        
        for (int i = 0; i < myStringCharArr.length; i++) {
            if (myStringCharArr[i]=='a' || myStringCharArr[i]=='A'){
                answer += 'A';
            } else {
                answer += Character.toLowerCase(myStringCharArr[i]);
            }
        }
        
        return answer;
    }
}