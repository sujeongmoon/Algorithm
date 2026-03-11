import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); // 1. 먼저 정렬
        
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        
        while (left <= right) {
            // 가장 가벼운 사람 + 가장 무거운 사람의 합 확인
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람 보트에 탑승
            }
            // 무거운 사람은 합이 넘든 안 넘든 무조건 이번 보트에 탐
            right--; 
            answer++; // 보트 사용 횟수 증가
        }
        
        return answer;
    }
}