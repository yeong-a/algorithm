import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				int prev = 0;
				for (int j = 0; j < N; j++) {
					if (table[j][i] == 1) {
						prev = 1;
					}
					if (table[j][i] == 2 && prev == 1) {
						prev = 2;
						res++;
					}
				}
			}
			System.out.printf("#%d %d\n", t, res);
		}
	}
}
