import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        // Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스)
        // 시작인덱스: n - 1
        // 끝인덱스: num_list.length (마지막까지 포함)
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}