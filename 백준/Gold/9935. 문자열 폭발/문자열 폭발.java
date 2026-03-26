import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));

			if (sb.length() >= bomb.length()) {
				boolean isMatch = true;

				for (int j = 0; j < bomb.length(); j++) {
					if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
						isMatch = false;
						break;
					}
				}

				if (isMatch) {
					sb.delete(sb.length() - bomb.length(), sb.length());
				}
			}
		}

		String answer = sb.toString();
		bw.write(answer.length() != 0 ? answer : "FRULA" );
		bw.flush();
		bw.close();
	}
}
