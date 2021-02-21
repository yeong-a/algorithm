import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		solution(arr);
	}

	static void solution(int[][] arr) {
		int n = arr.length;
		int sum = 0;		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += arr[i][j];
			}
		}
		if (sum == 0) {
			System.out.print("0");
			return;
		} else if (sum == n * n) {
			System.out.print("1");
			return;
		}
		System.out.print("(");
		if (n == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j]);
				}
			}
		} else {
			int[][] temp = new int[n/2][n/2];
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			solution(temp);
			for (int i = 0; i < n/2; i++) {
				for (int j = n/2; j < n; j++) {
					temp[i][j-n/2] = arr[i][j];
				}
			}
			solution(temp);
			for (int i = n/2; i < n; i++) {
				for (int j = 0; j < n/2; j++) {
					temp[i-n/2][j] = arr[i][j];
				}
			}
			solution(temp);
			for (int i = n/2; i < n; i++) {
				for (int j = n/2; j < n; j++) {
					temp[i-n/2][j-n/2] = arr[i][j];
				}
			}
			solution(temp);
		}
		System.out.print(")");
	}
}
