import java.util.Scanner;
 
class Solution {
    static int[][] dir = {{0, 1}, {1 ,0}, {0, -1}, {-1, 0}};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            System.out.printf("#%d\n", t);
            snail(arr, N);
        }
    }
 
    static void snail(int[][] arr, int N) {
        int cnt = 1;
        int d = 0;
        int curR = 0;
        int curC = 0;
        arr[curR][curC] = cnt++;
 
        while (cnt <= N*N) {
            int dr = dir[d][0];
            int dc = dir[d][1];
            if (curR + dr >= N || curR + dr < 0 || curC + dc >= N || curC + dc < 0
                    || arr[curR + dr][curC + dc] != 0) {
                if (++d == 4) {
                    d = 0;
                }
            } else {
                curR += dr;
                curC += dc;
                arr[curR][curC] = cnt++;
            }
        }
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
