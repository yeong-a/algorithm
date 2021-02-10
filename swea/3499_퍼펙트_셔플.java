import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            int range = (int)Math.ceil(N/2.0);
            for (int i = 0; i < range; i++) {
                queue1.offer(arr[i]);
            }
            for (int i = range; i < N; i++) {
                queue2.offer(arr[i]);
            }
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                String str1 = queue1.poll();
                String str2 = queue2.poll();
                if (str1 != null) {
                    sb.append(str1 + " ");
                }
                if (str2 != null) {
                    sb.append(str2 + " ");
                }
            }
            System.out.printf("#%d ", t);
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
    }
}