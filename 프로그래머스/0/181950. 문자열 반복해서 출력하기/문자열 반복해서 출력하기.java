import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            word.append(str);
        }
        System.out.println(word.toString());
    }
}