class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        //denom1, denom2의 최소공배수를 구하고, numer에 값을 곱해준 뒤 합을 구해야 함
        // 그 합과 최소공배수가 나눠지면 나눠줘야함.
        
        numer1 *= denom2;
        numer2 *= denom1;
        
        int numer = numer1 + numer2;
        int denom = denom1 * denom2;
    
        int max = Math.max(numer, denom);
        int min = Math.min(numer, denom);

        //최대공약수 구하기 - 유클리드 호제법
        int gcdnum = gcd(max, min);
        answer[0] = numer/gcdnum;
        answer[1] = denom/gcdnum;
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
