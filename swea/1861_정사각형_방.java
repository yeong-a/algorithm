import java.io.*;
import java.util.*;
 
public class Solution{
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[(N*N) + 1];
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count[arr[i][j]] = findRoom(arr, i, j, arr[i][j], 1);
                }
            }
            int max = 0;
            int startNum = 0;
            for (int i = 1; i <= N*N; i++) {
                if (max < count[i]) {
                    max = count[i];
                    startNum = i;
                }
            }
            System.out.printf("#%d %d %d\n", t, startNum, max);
        }
    }
 
    static int findRoom(int[][] arr, int r, int c, int index, int cnt) {
        int N = arr.length;
        for (int i = 0; i < 4; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];
            if (dr >= 0 && dr < N && dc >= 0 && dc < N && arr[dr][dc] == index + 1) {
                return findRoom(arr, dr, dc, index + 1, cnt + 1);
            }
        }
        return cnt;
    }
}