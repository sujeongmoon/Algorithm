import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// 두 정수 A B 입력 후 A * B 출력

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int A =  Integer.parseInt(st.nextToken());
			int B =  Integer.parseInt(st.nextToken());
			int answer = A * B;
			bw.write(String.valueOf(answer));
		}

		// bw.write(A * B);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void main(String[] args) throws IOException {
		solution();
	}
}