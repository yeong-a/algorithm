import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] start = new int[N / 2];
		int[] link = new int[N / 2];

		int[] P = new int[N];
		for (int i = N - 1; i >= N / 2; i--) {
			P[i] = 1;
		}

		int res = Integer.MAX_VALUE;
		do {
			int startCnt = 0;
			int linkCnt = 0;
			for (int i = 0; i < N; i++) {
				if (P[i] == 1) { // 스타트팀
					start[startCnt++] = i;
				} else { // 링크팀
					link[linkCnt++] = i;
				}
			}

			int startRes = 0;
			int linkRes = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					startRes += map[start[i]][start[j]] + map[start[j]][start[i]];
					linkRes += map[link[i]][link[j]] + map[link[j]][link[i]];
				}
			}
			res = Math.min(res, Math.abs(startRes - linkRes));
		} while (np(P));

		System.out.println(res);
	}

	public static boolean np(int[] arr) {
		int N = arr.length;
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}
		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (arr[i - 1] >= arr[j]) {
			--j;
		}

		swap(arr, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
