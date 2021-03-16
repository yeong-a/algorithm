import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Contact {
	int depth;
	int number;

	public Contact(int depth, int number) {
		this.depth = depth;
		this.number = number;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N + 1][N + 1];
			boolean visited[] = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			Queue<Contact> queue = new LinkedList<>();
			queue.offer(new Contact(0, start));
			visited[start] = true;
			int maxDepth = 0;
			int res = start;
			while (!queue.isEmpty()) {
				Contact temp = queue.poll();
				if (maxDepth < temp.depth) {
					maxDepth = temp.depth;
					res = 0;
				}
				if (maxDepth == temp.depth && res < temp.number) {
					res = temp.number;
				}
				for (int i = 1; i <= N; i++) {
					if (arr[temp.number][i] == 1 && !visited[i]) {
						queue.offer(new Contact(temp.depth + 1, i));
						visited[i] = true;
					}
				}
			}
			System.out.printf("#%d %d\n", t, res);
		}
	}
}
