import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] steps = new int[6][2];
		int wMax = 0;
		int hMax = 0;
		for (int i = 0; i < 6; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			steps[i][0] = Integer.parseInt(st.nextToken());
			steps[i][1] = Integer.parseInt(st.nextToken());
			if (steps[i][0] >= 3) {
				hMax = Math.max(hMax, steps[i][1]);
			} else {
				wMax = Math.max(wMax, steps[i][1]);
			}
		}
		int area = 1;
		for (int i = 0; i < 6; i++) {
			if (steps[(i+5)%6][0] == steps[(i+1)%6][0]) {
				area *= steps[i][1];
			}
		}
		System.out.println(((hMax * wMax) - area) * K);
	}
}
