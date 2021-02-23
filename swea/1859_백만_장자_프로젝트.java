import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            long res = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                    continue;
                } else {
                    res += max - arr[i];
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
