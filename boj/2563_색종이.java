import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] arr = new boolean[100][100];
		int N = sc.nextInt();
		int count = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int m = 0; m < 10; m++) {
				for (int n = 0; n < 10; n++) {
					if (arr[x+m][y+n]) {
						count++;
					} else {
						arr[x+m][y+n] = true;
					}
				}
			}
		}
		System.out.println(N * 100 - count);
	}
}