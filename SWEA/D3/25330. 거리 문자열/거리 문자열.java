import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String S = br.readLine();
			int SLength = S.length();
			boolean flag = true;

			Map<Character, Integer> SIndexMap = new HashMap<>();

			for (int j = 0; j < SLength; j++) {
				if (SIndexMap.containsKey(S.charAt(j))) {
					if (SIndexMap.get(S.charAt(j)) == j) {
						continue;
					} else {
						flag = false;
						break;
					}
				}
				if (j + S.charAt(j)-'0' + 1 >= SLength) {
					flag = false;
					break;
				}
				if (S.charAt(j) == S.charAt(j + S.charAt(j) - '0' + 1)) {
					SIndexMap.put(S.charAt(j), j + S.charAt(j) - '0' + 1);
				} else {
                    flag = false;
                    break;
                }
			}
			if (flag == true) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	}
}