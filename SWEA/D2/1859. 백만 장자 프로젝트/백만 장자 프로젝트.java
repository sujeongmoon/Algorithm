import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int N;

		for (int i = 1; i<= T; i++){
			N = sc.nextInt();
			long[] arr = new long[N];
			for (int j = 0; j<N; j++){
				arr[j] = sc.nextLong();
			}
			long result =0;
			int maxIdx = -1;
			int tmp=0;

			while (maxIdx<N-1){
				long max = -1;
				for (int j = maxIdx+1; j<N; j++){
					if (arr[j]>=max){
						max = arr[j];
						tmp = j;
					}
				}

				for (int j = maxIdx+1; j<tmp; j++){
					result = result+max-arr[j];
				}
				maxIdx = tmp;
			}
			System.out.println("#"+i+" "+result);
        }
	}
}