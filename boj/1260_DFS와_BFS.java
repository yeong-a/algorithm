import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = true;
			arr[c][r] = true;
		}
		dfs(arr, V);
		bfs(arr, V);
	}

	static void dfs(boolean[][] arr, int V) {
		int N = arr.length - 1;
		boolean[] visited = new boolean[N + 1];
		Stack<Integer> stack = new Stack<>();
		stack.push(V);
		visited[V] = true;
		System.out.print(V + " ");
		while (!stack.isEmpty()) {
			int top = stack.peek();
			boolean found = false;
			for (int j = 1; j <= N; j++) {
				if (arr[top][j] && !visited[j]) {
					found = true;
					stack.push(j);
					visited[j] = true;
					System.out.print(j + " ");
					break;
				}
			}
			if (!found) {
				stack.pop();
			}
		}
		System.out.println();
	}

	static void bfs(boolean[][] arr, int V) {
		int N = arr.length - 1;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited[V] = true;
		while (!queue.isEmpty()) {
			int first = queue.poll();
			System.out.print(first + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[first][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
