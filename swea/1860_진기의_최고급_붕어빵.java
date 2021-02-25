import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			String res = "Possible";
			if (arr[0] < M) {
				res = "Impossible";
			} else {
				for (int i = 1; i < N; i++) {
					int bbang = arr[i] / M * K - i;
					if (bbang <= 0) {
						res = "Impossible";
					}
				}
			}
			System.out.printf("#%d %s\n", t, res);
		}
	}
}
