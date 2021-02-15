import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[i] = input;
			sum += input;
		}
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 100;
					arr[j] = 100;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (arr[i] != 100) {
				System.out.println(arr[i]);
			}
		}
	}
}
