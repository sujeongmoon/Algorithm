class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        // 2진수로 바꾸기
        // 맨 앞에 0 추가하기
        // 만약 1의자리가 0이라면 1로 바꾸면 끝
        // 아니라면 뒤에서부터 돌아서 제일 먼저 발견하는 0을 1로 바꾸고 그 다음을 0으로 바꿈
        
        for (int i = 0; i < numbers.length; i++) {
            
            StringBuilder sb = new StringBuilder();
            sb.append('0').append(Long.toString(numbers[i], 2)); // '0' + 이진수
            
            if (sb.charAt(sb.length()-1) == '0') {
                sb.setCharAt(sb.length()-1,'1');
                answer[i] = Long.parseLong(sb.toString(), 2);
            } else {
                for (int j = sb.length() - 2; j >= 0; j--) {
                    if (sb.charAt(j) == '0') {
                        sb.setCharAt(j, '1');
                        sb.setCharAt(j+1, '0');
                        answer[i] = Long.parseLong(sb.toString(), 2);
                        break;
                    }
                }
            }
            
            answer[i] = Long.parseLong(sb.toString(), 2);        
            
        }

        return answer;
    }
}