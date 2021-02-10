import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		String str = br.readLine();
		String[][] res = null;
		st = new StringTokenizer(str);
		res = operation(arr, Integer.parseInt(st.nextToken()));
		for (int i = 0; i < R - 1; i++) {
			res = operation(res, Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < res.length; i++ ) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	static String[][] operation(String[][] arr, int num) {
		int N = arr.length;
		int M = arr[0].length;

		switch (num) {
		case 1: {
			String[] temp = new String[M];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M; j++) {
					temp[j] = arr[i][j];
					arr[i][j] = arr[N-i-1][j];
					arr[N-i-1][j] = temp[j];
				}
			}
			return arr;
		}
		case 2: {
			String[] temp = new String[N];
			for (int i = 0; i < M/2; i++) {
				for (int j = 0; j < N; j++) {
					temp[j] = arr[j][i];
					arr[j][i] = arr[j][M-i-1];
					arr[j][M-i-1] = temp[j];
				}
			}
			return arr;
		}
		case 3: {
			String[][] res = new String[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = N-1; j >= 0; j--) {
					res[i][N-1-j] = arr[j][i];
				}
			}
			return res;
		}
		case 4: {
			String[][] res = new String[M][N];
			for (int i = M-1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					res[M-1-i][j] = arr[j][i];
				}
			}
			return res;
		}
		case 5: {
			String[][] temp = new String[N/2][M/2];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					arr[i-N/2][j] = arr[i][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					arr[i][j-M/2] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					arr[i+N/2][j] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					arr[i][j+M/2] = temp[i][j];
				}
			}
			return arr;
		}
		case 6: {
			String[][] temp = new String[N/2][M/2];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					arr[i][j-M/2] = arr[i][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					arr[i-N/2][j] = arr[i][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					arr[i][j+M/2] = arr[i][j];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					arr[i+N/2][j] = temp[i][j];
				}
			}
			return arr;
		}
		}
		return null;
	}
}