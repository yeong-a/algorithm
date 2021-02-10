import java.io.*;
import java.util.*;

class Solution {
	static int[][] dir = {{0, -1}, {0, 1}};
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			int[][] arr = new int[100][100];
			int nowC = 0;
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						nowC = j;
					}
				}
			}
			int res = ladder(arr, 99, nowC);
			System.out.printf("#%d %d\n", t, res);
		}
	}

	static int ladder(int[][] arr, int nowR, int nowC) {
		if (nowR == 0) {
			return nowC;
		}
		int dc = 0;
		if (nowC >= 1 && arr[nowR][nowC - 1] == 1) {
			dc = -1;
		} else if (nowC < 99 && arr[nowR][nowC + 1] == 1) {
			dc = 1;
		}
		if (dc != 0) {
			while (nowC + dc >= 0 && nowC + dc < 100 && arr[nowR][nowC + dc] == 1) {
				nowC += dc;
			}
		}
		return ladder(arr, nowR - 1, nowC);
	}
}