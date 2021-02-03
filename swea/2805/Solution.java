import java.util.Scanner;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int sum = 0;
            int pad = 0;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            for (int i = 0; i <= N/2; i++, pad++) {
                for (int j = 0; j < N; j++) {
                    if (j >= N/2 - pad && j <= N/2 + pad) {
                        sum += arr[i][j];
                    }
                }
            }
            pad -= 2;
            for (int i = N/2 + 1; i < N; i++, pad--) {
                for (int j = 0; j < N; j++) {
                    if (j >= N/2 - pad && j <= N/2 + pad) {
                        sum += arr[i][j];
                    }
                }
            }
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}
