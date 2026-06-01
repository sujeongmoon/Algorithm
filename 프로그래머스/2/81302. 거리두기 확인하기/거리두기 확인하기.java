import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 대기실은 5개. 맨해튼거리가 2 이하 && 파티션 없는 경우 xx (2초과 || 파티션 있으면 oo)
    
            
        // 응시자의 r, c만을 담은 리스트를 만든다
        // 리스트를 이중 for문으로 돌면서, 맨해튼거리가 2 보다 크면 반복문 벗어나도록
        
        
        for (int i = 0; i < 5; i++) {
            // 각 대기실 돌기
            String[] space = places[i]; // 현재 각각의 대기실
            ArrayList<int[]> studentList = new ArrayList<>(); // 응시자의 r,c를 담은 리스트
            
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (space[j].charAt(k) == 'P') {
                        // 학생인경우 r, c를 리스트에 저장
                        studentList.add(new int[] {j, k});
                    }
                }
            }
            
            boolean isVirus = false;
            
            for (int j = 0; j < studentList.size() - 1; j++) {
                for (int k = j+1; k < studentList.size(); k++) {
                    int[] student1 = studentList.get(j);
                    int[] student2 = studentList.get(k); // 비교할 학생들 구하기
                    
                    int distance = calManhatten(student1, student2);
                    if (distance > 2) { // 거리가 2보다 크면 패스
                        continue;
                    }
                    
// //                     // 맨해튼 거리가 1인 경우, 무조건 틀림. 만약 2인경우-> x값 차이가 2인경우, y값 동일하고 x는 둘중 작은거+1 자리가 x인지 여부 확인 (틀리면 무조건 0이 된다)
// //                    // y값 차이가 2인경우 x값 동일하고 y는 둘중 작은거+1자리가 x인지 여부 확인
// //                    // 아닌 경우는 둘다 각각 1이라는 뜻, x값 큰거에 y값 작은거, x값 작은거에 y값 큰거 자리가 x인지 여부 확인
// //                 //다 맞으면 1 넣어주면 됨, 즉 둘 중 하나라도 파티션이 없다면 거짓이 됨
                    
                    if (distance == 1) {
                        isVirus = true;
                        break;
                    }
                    
                    // row가 다른 경우
                    if (Math.abs(student1[0] - student2[0]) == 2) {
                        int r = Math.min(student1[0], student2[0]) + 1;
                        int c = student1[1]; //
                        isVirus = !isPartition(r, c, space); // 파티션이 없는 경우 바이러스에 걸리는 것
                    } else if (Math.abs(student1[1] - student2[1]) == 2) {
                        // col 다른 경우
                        int r = student1[0];
                        int c = Math.min(student1[1], student2[1]) + 1;
                        isVirus = !isPartition(r, c, space); // 파티션이 없는 경우 바이러스에 걸리는 것
                    } else {
                        
                        int r1 = student1[0];
                        int c1 = student2[1];

                        int r2 = student2[0];
                        int c2 = student1[1];
                        
                        
                        isVirus = !(isPartition(r1, c1, space) && isPartition(r2, c2, space));
                    }

                    if (isVirus) {
                        break;
                    }
                }
                
            
                if (isVirus) {
                    break;
                }
            }
            
            if (isVirus) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        
         }
            
        // 거리두기 지키면 1, 안 지키면 0 리턴
        return answer;
    }
        
    
    public static int calManhatten(int[] student1, int[] student2) {
        int r1 = student1[0];
        int c1 = student1[1];
        
        int r2 = student2[0];
        int c2 = student2[1];
        
        // 맨해튼거리 : Math.abs(r1-r2) + Math.abs(c1-c2)
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    
    static boolean isPartition(int r, int c, String[] space) {
        // 파티션이 있는지 찾자
        if (space[r].charAt(c) == 'X') {
            return true;
        }
        return false;
    }
}