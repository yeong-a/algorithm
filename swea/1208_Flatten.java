import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int[] arr = new int[100];
            int n = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.printf("#%d %d\n", tc, arr[99]-arr[0]);
        }
    }
}
