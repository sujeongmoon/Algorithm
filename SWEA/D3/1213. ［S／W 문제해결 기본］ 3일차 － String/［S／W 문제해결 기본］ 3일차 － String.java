import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10; i++) {

			int answer = 0;

			int testCaseNumber = Integer.parseInt(br.readLine().trim());
			String word = br.readLine();
			String sentence = br.readLine();

			for (int j = 0; j <= sentence.length() - word.length(); j++) {
				if (sentence.charAt(j) == word.charAt(0)) {
					boolean isSameWord = true;
					for (int k = 0; k < word.length(); k++) {
						if  (sentence.charAt(j + k) != word.charAt(k)) {
							isSameWord = false;
							break;
						}
					}
					if(isSameWord) {
						answer++;
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCaseNumber).append(" ").append(answer);
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}