import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[20][20];
 
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
            }
        }
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                for (int d = 0; d < 4; d++) {
                    if (map[i][j] != 0 && omok(map, i, j, d, 1) == 5) {
                        System.out.println(map[i][j]);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
 
    static int omok(int[][] arr, int r, int c, int d, int cnt) {
        int oppoR = r-dir[d][0];
        int oppoC = c-dir[d][1];
        if (cnt == 1 && oppoR >= 1 && oppoR <= 19 && oppoC >= 1  && oppoC <= 19
                && arr[r][c] == arr[oppoR][oppoC]) {
            return 0;
        }
        int nextR = r + dir[d][0];
        int nextC = c + dir[d][1];
        if (nextR >= 1 && nextR <= 19 && nextC >= 1 && nextC <= 19
                && arr[r][c] == arr[nextR][nextC]) {
            return Math.max(cnt, omok(arr, nextR, nextC, d, cnt+1));
        }
        return cnt;
    }
}
