import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // (고속도로 진입 지점, 나간 지점) (해당 지점도 포함)
        
        // int[][] routes[]를 routes[][1]의 순서대로 오름차순 정렬
        // Arrays.sort(routes, 
        //             Comparator.comparingInt((int[] arr) -> arr[1]) // int[] 명시!!!
        //             .thenComparingInt((int[] arr) -> arr[0]) 
        //            );
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        //ArrayList<Integer> cameraList = new ArrayList<>(); // 카메라 위치 리스트
        //cameraList.add(routes[0][1]); // 가장 첫 번째 카메라 위치 리스트에 넣고 두 번째부터 반복문 돌기
        
        // 리스트에 보관할 필요 없고 int값만 알면 됨
        if (routes.length == 0) {
            return 0;
        }
        
        int recentCamera = routes[0][1];
        answer++;
        
        for (int i = 1; i < routes.length; i++) {
            
            int[] nowCar = routes[i]; // 현재 보고있는 차량
            //int recentCamera = cameraList.get(cameraList.size() - 1); // 가장 최근에 넣은 카메라 위치
            
            // 만약 가장 최근에 넣은 카메라 위치가 현재 시작점보다 크거나 같으면 이미 찍혔음으로 패스
            // 아니면 끝점 리스트에 추가
            if (nowCar[0] <= recentCamera) {
                continue;
            } else {
                recentCamera = nowCar[1];
                answer++;
            }
            
        }
        
        return answer;
    }
}