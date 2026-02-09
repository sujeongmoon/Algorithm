class Solution {
    public int solution(int a, int b, int c) {
       
        
        if (a==b && a==c) {
            return 3*a*3*a*a*3*a*a*a;
        } else if (a==b || b==c || a==c) {
            return (a+b+c) * (a*a+b*b+c*c);
        } else {
            return a+b+c;
        }
        
   
    }
}