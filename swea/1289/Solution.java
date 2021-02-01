import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String str = sc.next();
			int flag = 0;
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) - 48 != flag) {
					count++;
					if (flag == 0) {
						flag = 1;
					} else {
						flag = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", t, count);
		}
	}
}
