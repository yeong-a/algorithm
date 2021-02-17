import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Chicken {
	int r, c;

	public Chicken(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Chicken> list = new ArrayList<>();

		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < N; j++) {
				char input = st.nextToken().charAt(0);
				if (input != '2') {
					arr[i][j] = input;
				} else {
					list.add(new Chicken(i, j));
				}
			}
		}
    
		int n = list.size();
		int[] P = new int[n];
		for (int i = n-1; i >= n-M; i--) {
			P[i] = 1;
		}
    
		int res = Integer.MAX_VALUE;
		do {
			int r = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				if (P[i] == 1) {
					r = list.get(i).r;
					c = list.get(i).c;
					arr[r][c] = '2';
				}
			}
			res = Math.min(res, calc(arr));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == '2') {
						arr[i][j] = '0';
					}
				}
			}

		} while (np(P));
		System.out.println(res);
	}

	static int calc(char[][] arr) {
		int sum = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (arr[i][j] == '1') {
					int minDis = Integer.MAX_VALUE;
					for (int m = 0; m < len; m++) {
						for (int n = 0; n < len; n++) {
							if (arr[m][n] == '2') {
								int dis = Math.abs(m-i) + Math.abs(n-j);
								minDis = Math.min(minDis, dis);
							}
						}
					}
					sum += minDis;
				}
			}
		}
		return sum;
	}

	public static boolean np(int[] arr) {
		int N = arr.length;
		int i = N-1;
		while (i>0 && arr[i-1] >= arr[i]) {
			--i;
		}
    
		if (i == 0) {
			return false;
		}
	
		int j = N-1;
		while (arr[i-1] >= arr[j]) {
			--j;
		}
	
		swap(arr, i-1, j);

	
		int k = N-1;
		while (i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}

	private static void swap(int[] arr, int i,  int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
