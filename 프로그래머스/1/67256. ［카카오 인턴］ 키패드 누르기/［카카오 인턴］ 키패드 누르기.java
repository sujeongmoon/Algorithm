class Solution {
    public String solution(int[] numbers, String hand) {
        
        // 엄지손가락은 상하좌우 4가지 방향
        // 키패드 이동 한 칸은 거리 1
        
        // 가운데 열의 숫자 입력 시 : 더 가까운 엄지손가락
        // 오른손잡이는 오른손 엄지
        
        // numbers : 순서대로 누를 번호
        // hand: 왼손잡이/오른손잡이
        // answer: 각 번호를 누른 엄지손가락이 왼손인지 엄지손가락인지를 나타냄.
        
        StringBuilder sb = new StringBuilder();
        
        
        int[] nowLeftHand = new int[] {3, 0};
        int[] nowRightHand = new int[] {3, 2};
        
        int m;
        int n;
        
        int fromLeftHandDist;
        int fromRightHandDist;
        
        boolean isL;
        
        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] == 0) {
                m = 3;
                n = 1;
            } else {
                m = (numbers[i] - 1) / 3;
                n = (numbers[i] - 1) % 3;
            }
            
            if (n == 0) {
                isL = true;
                
            } else if (n == 2) {
                isL = false;
            } else { // n == 1
                fromLeftHandDist = Math.abs(nowLeftHand[0] - m) + Math.abs(nowLeftHand[1] - n);
                fromRightHandDist = Math.abs(nowRightHand[0] - m) + Math.abs(nowRightHand[1] - n);
                
                if (fromLeftHandDist == fromRightHandDist) {
                    if (hand.equals("left")) {
                        isL = true;
                    } else {
                        isL = false;
                    }
                } else if (fromLeftHandDist > fromRightHandDist) {
                    isL = false;
                } else {
                    isL = true;
                }
            }
            
            if (isL) {
                sb.append('L');
                nowLeftHand[0] = m;
                nowLeftHand[1] = n;
            } else {
                sb.append('R');
                nowRightHand[0] = m;
                nowRightHand[1] = n;
            }
            
            
        }
        
        
        return sb.toString();
    }
}