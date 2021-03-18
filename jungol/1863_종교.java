import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int parents[];

	static void make(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = -1;
		}
	}

	static int findSet(int a) {
		if (parents[a] < 0) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생의 수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수

		parents = new int[n];
		make(n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (parents[i] < 0) {
				res += 1;
			}
		}
		System.out.println(res);
	}
}
