import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		boolean flag = false;

		while (queue.size() != 1) {
			if (flag) {
				queue.offer(queue.poll());
			} else {
				queue.poll();
			}
			flag = !flag;
		}
		System.out.println(queue.poll());
	}
}