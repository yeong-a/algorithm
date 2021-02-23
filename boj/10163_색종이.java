import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] area = new int[N + 1];
		int[][] arr = new int[101][101];
		int flag = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			for (int m = r; m < r + h; m++) {
				for (int n = c; n < c + w; n++) {
					arr[m][n] = flag + 1;
				}
			}
			flag++;
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				area[arr[i][j]]++;
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(area[i]);
		}
	}
}
