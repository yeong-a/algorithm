import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int temp;
			for (int i = 0; i < K - 1; i++) {
				temp = queue.poll();
				queue.offer(temp);
			}
			sb.append(queue.poll() + ", ");
		}
		sb.setLength(sb.length() - 2);
		System.out.println("<" + sb + ">");
	}
}