import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int res = 1;
			for (int i = 0; i < N/2; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				st.nextToken();
				String operator = st.nextToken();
				if (!operator.equals("-") && !operator.equals("+") &&
						!operator.equals("*") && !operator.equals("/")) {
					res = 0;
				}
			}
			for (int i = N/2; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				st.nextToken();
				String leaf = st.nextToken();
				if (leaf.equals("-") || leaf.equals("+") ||
						leaf.equals("*") || leaf.equals("/")) {
					res = 0;
				}
			}
			System.out.printf("#%d %d\n", t, res);
		}
	}
}
