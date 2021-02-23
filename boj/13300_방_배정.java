import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] rooms = new int[7][2];

		int res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			rooms[grade][gender]++;
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 1; j++) {
				if (rooms[i][j] >= 1) {
					res++;
				}
				if (rooms[i][j] > K) {
					while (rooms[i][j] > K) {
						res++;
						rooms[i][j] -= K;
					}
				}
			}
		}
		System.out.println(res);
	}
}
