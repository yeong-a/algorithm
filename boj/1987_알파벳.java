import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited = new boolean[26];
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int R = Integer.parseInt(st.nextToken());
		st.nextToken();
		char[][] map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(dfs(map, 0, 0, 1));
	}

	static int dfs(char[][] map, int r, int c, int length) {
		int R = map.length;
		int C = map[0].length;
		int max = length;
		visited[map[r][c] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int dr = r + dir[i][0];
			int dc = c + dir[i][1];
			if (dr >= 0 && dr < R && dc >= 0 && dc < C && !visited[map[dr][dc] - 'A']) {
				max = Math.max(max, dfs(map, dr, dc, length+1));
			}
		}
		visited[map[r][c] - 'A'] = false;
		return max;
	}
}
