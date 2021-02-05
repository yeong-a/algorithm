import java.io.*;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			str = str.replace("()", "X");
			int stickCnt = 0;
			int totalCnt = 0;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				if (ch == '(') {
					stickCnt += 1;
					totalCnt += 1;
				} else if (ch == ')') {
					stickCnt -= 1;
				} else if (ch == 'X') {
					totalCnt += stickCnt;
				}
			}
			System.out.printf("#%d %d\n", t, totalCnt);
		}
	}
}