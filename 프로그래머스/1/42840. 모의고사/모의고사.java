import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // int[] answer = {};
        int [] students = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i ++) {
            if (answers[i] == 1) { // 정답이 1인 경우
                if ((i+1) % 5 == 1) {
                    students[0]++;
                }
                if ((i+1) % 8 == 2) {
                    students[1]++;
                }
                if ((i+1) % 10 == 3 || (i+1) % 10 == 4) {
                    students[2]++;
                }
            } else if (answers[i] == 2) { //정답이 2인 경우
                if ((i+1) % 5 == 2) {
                    students[0]++;
                }
                if (((i+1) % 8) % 2 == 1) {
                    students[1]++;
                }
                if ((i+1) % 10 == 5 || (i+1) % 10 == 6) {
                    students[2]++;
                }
            } else if (answers[i] == 3) { //정답이 3인 경우
                if ((i+1) % 5 == 3) {
                    students[0]++;
                }
                if ((i+1) % 8 == 4) {
                    students[1]++;
                }
                if ((i+1) % 10 == 1 || (i+1) % 10 == 2) {
                    students[2]++;
                }
            } else if (answers[i] == 4) { //정답이 4인 경우
                if ((i+1) % 5 == 4) {
                    students[0]++;
                }
                if ((i+1) % 8 == 6) {
                    students[1]++;
                }
                if ((i+1) % 10 == 7 || (i+1) % 10 == 8) {
                    students[2]++;
                }
            } else if (answers[i] == 5) { //정답이 5인 경우
                if ((i+1) % 5 == 0) {
                    students[0]++;
                }
                if ((i+1) % 8 == 0) {
                    students[1]++;
                }
                if ((i+1) % 10 == 9 || (i+1) % 10 == 0) {
                    students[2]++;
                }
            }
            
        }
        
        // 최댓값을 찾는다
        int max = 0;
        for (int i = 0; i < students.length; i++) {
            if (max < students[i]) {
                max = students[i];
            }
        }
        
        // 최댓값과 동일한 수를 맞춘 학생을 찾는다
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < students.length; i++) {
            if (max == students[i]){
                answerList.add(i+1);
            }
        }       
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}