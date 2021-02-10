import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[][] arr = new int[9][9];
            int res = 1;
            for (int i = 0; i < 9; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                for (int j = 0; j < 9; j++) {
                    int in = Integer.parseInt(st.nextToken());
                    arr[i][j] = in;
                }
            }
            res = check(arr);
            System.out.printf("#%d %d\n", t, res);
        }
    }
    static int check(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < 9; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            if (sum1 != 45 || sum2 != 45) {
                return 0;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int sum3 = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        sum3 += arr[i+m][j+n];
                    }
                }
                if (sum3 != 45) {
                    return 0;
                }
            }
        }
        return 1;
    }
}