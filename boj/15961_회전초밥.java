import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] kind = new int[d + 1];
        int res = 1;
        kind[c] += 1;
        for (int i = 0; i < k; i++) {
            kind[sushi[i]]++;
            if (kind[sushi[i]] == 1 ) {
                res++;
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            kind[sushi[i]]--;
            if (kind[sushi[i]] == 0) {
                res -= 1;
            }
            kind[sushi[(i + k) % N]]++;
            if (kind[sushi[(i + k) % N]] == 1) {
                res += 1;
            }
            max = Math.max(max, res);
        }
        System.out.println(max);
    }
}
