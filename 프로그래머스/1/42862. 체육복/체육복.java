class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        
        // 여벌 체육복이 있는 학생들이 없는 학생들에게 체육복을 빌려준다.
        // 앞이나 뒤 학생에게만 체육복을 빌려줄 수 있다.
        // 전체학생 수 n, 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호 reverse
        
        // 2명 이상 30명 이하 / 체육복을 도난당한 학생의 수는 1명 이상 n명 이하
        // 여벌 체육복을 가져온 상황이 도난당했을 수 있음. 이 학생은 남은 체육복이 하나라서 다른 학생에게 체육복 빌려줄 수 없음.
        
        //answer = 체육수업을 들을 수 있는 학생의 최댓값.
        
        // ! 1번학생은 0번 인덱스
        
        // 전체 학생의 배열 만들기
        int[] students = new int[n];
        
        int lostIndex = 1;
        int reserveIndex = 1;
        
        // 전체 학생에게 1 할당, i==lost면 -1, i==reverse면 +1
        for(int i = 0; i < students.length; i++) {
            students[i] = 1;
            for (int j = 0; j < lost.length; j++) {
                if (lost[j]-1 == i) {
                    students[i]--;
                    break;
                }
            }
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j]-1 == i) {
                    students[i]++;
                    break;
                }
            }
        }
        
        // for문을 돌면서, 내가 2이고 앞뒤가 0인 경우에 나눠줌
        if (students[0] == 2  && students[1] == 0) {
            students[0] --;
            students[1] ++;
        }
        
        for (int i = 1; i < students.length-1; i++) {
            if (students[i] == 2 && students[i-1] == 0) {
                students[i-1] ++;
                students[i] --;
            } else if (students[i] ==2 && students[i+1] == 0) {
                students[i+1] ++;
                students[i] --;
            }
        }
        
        if (students[students.length-1] == 2 && students[students.length-2] == 0) {
            students[students.length-1] --;
            students[students.length-2] ++;
        }
        
        // 마지막에 for문을 돌면서, 1 이상인 경우에 answer을 더한다.
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
            if (students[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}

    