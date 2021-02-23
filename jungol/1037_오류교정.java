import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (check(arr)) {
			System.out.println("OK");
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = arr[i][j] == 0 ? 1 : 0;
				if (check(arr)) {
					System.out.printf("Change bit (%d,%d)\n", i + 1, j + 1);
					return;
				}
				arr[i][j] = arr[i][j] == 0 ? 1 : 0;
			}
		}
		System.out.println("Corrupt");
	}

	static boolean check(int[][] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int cSum = 0;
			int rSum = 0;
			for (int j = 0; j < N; j++) {
				cSum += arr[i][j];
				rSum += arr[j][i];
			}
			if (cSum % 2 != 0 || rSum % 2 != 0) {
				return false;
			}
		}
		return true;
	}
}
