import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++){
			arr[i] = sc.nextInt();
		}
		int p = sc.nextInt();
		for (int i = 0; i < p; i++){
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if (gender == 1){
				for (int j = 1; j <= n; j++){
					if (j % num == 0) {
						arr[j] = 1 - arr[j];
					}
				}
			} else {
				arr[num] = 1 - arr[num];
				for (int l = num-1, r = num+1; l >= 1 && r <= n && arr[l] == arr[r]; l--, r++) {
					arr[l] = 1 - arr[l];
					arr[r] = 1 - arr[r];
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d ", arr[i]);
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
