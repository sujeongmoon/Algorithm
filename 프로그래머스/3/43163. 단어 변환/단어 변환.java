import java.util.*;

class Solution {
    
    static boolean[] isUsed;
    static int wordLength;
    static int answer = Integer.MAX_VALUE; // 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 
    
    
    public int solution(String begin, String target, String[] words) {        
        wordLength = begin.length(); // 문자열 길이
        isUsed = new boolean[words.length]; // 사용된 배열인지 확인
        
        // 백트래킹으로 더이상 갈 수 없는 경우에는 백
        for (int i = 0; i < words.length; i++) {
            
            backtracking(0, begin, target, words);
            
        }
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
    
    public static void backtracking(int depth, String now, String target, String[] words) {
        // now: 현재 가리키는 단어, target: 최종 목적지 단어, words: 다넝 배열 
        
        // // 이미 방문했다면 return -> 필요없음
        // if (isUsed[idx]) {
        //     return;
        // }
        
        // 같으면 종료
        if (now.equals(target)) {
            answer = Math.min(answer, depth);
        }
        
        // 한 글자 이상이 다르거나 같은 글자가 없으면 리턴
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            // 이미 방문한 단어면 스킵
            if (isUsed[i]) { 
                continue;
            }
            
            count = 0;
            for (int j = 0; j < wordLength; j++) {
                if (now.charAt(j) != words[i].charAt(j)) {
                    count++;
                }
            
            }
            if (count != 1) {
                continue;
            }
            
            //바꿀 수 있는 경우
            isUsed[i] = true;
            backtracking(depth + 1, words[i], target, words);
            isUsed[i] = false;
            
        }
        
    }
    
}