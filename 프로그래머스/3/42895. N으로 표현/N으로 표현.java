import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        // N이랑 사칙연산만 사용해서 표현할 수 있느 방법 중 N 사용횟수의 최솟값.
        // 5555
        // 5로 할수 있는 방법 다 미리 저장해두고 나중에 꺼내쓰기
        // 5 하나로 할 수 있는 거 : 5
        // 5 두개로 할 수 있는 거 : 5+5, 5*5, 5/5, 55 (10 25 1 55)
        // 5 3개로 할 수 있는 거 : ( 5두개로 할 수 있는거 ) + (5 1개로 할 수 있는거)
        
        
        if (N == number) {
            return 1; // 같은 경우에는 바로 리턴
        }
    
        List<Set<Integer>> dp = new ArrayList<>();
    
        // dp 준비, 인덱스 1~8만 사용(0은 x)
        for (int  i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // 초기값 넣기 ( 5 55 555 ...)
        int base = 0;
        for (int i = 1; i <= 8; i++) {
            base = base * 10 + N;
            dp.get(i).add(base);
        }
        
        // dp 채우기, 1은 5로 끝이니까 2부터
        for (int i = 2; i <= 8; i++) {
            
            Set<Integer> now = dp.get(i);
            
            for (int j = 1; j < i; j++) {
                
                // i를 얻기 위해서는 (j)와 (i-j)를 꺼내서 둘을 모두 +, -, *, / 해줘야함
                Set<Integer> setA = dp.get(j);
                Set<Integer> setB = dp.get(i-j);
                
                for (int a : setA) {
                    for (int b : setB) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        if (b != 0) {
                            now.add(a/b); // 0 나누기 방지
                        }
                    }
                }
                
                if (dp.get(i).contains(number)) {
                    return i;
                }
                
            }
            
        }
        
        
        return -1;
    }
}