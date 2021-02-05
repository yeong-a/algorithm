import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while (queue.size() > 1) {
			queue.poll();
			int card = queue.poll();
			queue.offer(card);
		}
		System.out.println(queue.poll());
	}
}