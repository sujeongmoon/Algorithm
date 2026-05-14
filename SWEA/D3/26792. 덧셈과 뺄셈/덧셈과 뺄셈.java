
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
            int plus = sc.nextInt();
            int minus = sc.nextInt();
            
            int a = 0;
            int b = 0;
            
            a = (plus + minus) / 2;
			b = a - minus;

			System.out.println(a + " " + b);


		}
	}
}