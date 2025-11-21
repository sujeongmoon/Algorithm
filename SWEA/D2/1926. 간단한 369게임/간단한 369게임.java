import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
               
		int N = Integer.parseInt(br.readLine());

		for(int i = 1; i <= N; i++)
		{
		
			String s = String.valueOf(i);
			int clap = 0;
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
					clap++;
				} else {
				}
			}
			if (clap >= 1) {
				for (int j = 1; j <= clap; j++) {
					sb.append('-');
				}
			} else {
				sb.append(i);
			}
			sb.append(' ');

		}
		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	}
    
}
