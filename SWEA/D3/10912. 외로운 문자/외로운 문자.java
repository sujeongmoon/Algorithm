/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제

import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T;
		T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String word = br.readLine();
            char[] wordArray = word.toCharArray();
            
            HashSet<Character> charSet = new HashSet<>();
            
            for (int i = 0; i < wordArray.length; i++) {
                if (!charSet.contains(wordArray[i])) {
                	charSet.add(wordArray[i]);
                } else {
                	charSet.remove(wordArray[i]);
                }
            }
           
            StringBuilder sb = new StringBuilder();           
            sb.append('#').append(test_case).append(' ');
            if (charSet.isEmpty()) {
            	sb.append("Good");
            } else {
            	charSet.stream().sorted().forEach(sb::append);	
            }
            sb.append('\n');
            bw.write(sb.toString());           
		}
        bw.flush();
        bw.close();
	}
}