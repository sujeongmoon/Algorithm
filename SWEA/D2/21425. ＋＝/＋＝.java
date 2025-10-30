import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int N = sc.nextInt();

			int count = 0;

			while(x <= N && y <= N) {
				if (x <= y) {
					x += y;
				} else {
					y += x;
				}
				count++;
			}
			System.out.println(count);
		}
	}
}