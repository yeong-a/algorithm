import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int N = new Scanner(System.in).nextInt();
		int cnt = 0;
		while (N > 0) {
			if (N % 5 == 0) {
				N -= 5;
				cnt++;
			} else if (N % 3 == 0) {
				N -= 3;
				cnt++;
			} else if (N > 5) {
				N -= 5;
				cnt++;
			} else {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
