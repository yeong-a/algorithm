import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int sum3 = 0, sum4 = 0;
			for (int i = 0; i < 100; i++) {
				int sum1 = 0, sum2 = 0;
				for (int j = 0; j < 100; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
				}
				max = Math.max(max, sum1);
				max = Math.max(max, sum2);

				sum3 += arr[i][i];
				sum4 += arr[i][99 - i];
			}
			max = Math.max(max, sum3);
			max = Math.max(max, sum4);
			System.out.printf("#%d %d\n", T, max);
		}
	}
}
