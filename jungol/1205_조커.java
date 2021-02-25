import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int joker = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				joker++;
			}
		}
		arr[N] = Integer.MAX_VALUE;
		if (joker == N) {
			System.out.println(N);
			return;
		}
		Arrays.sort(arr);
		int res = 0;
		for (int i = joker; i < N; i++) {
			int cnt = go(arr, joker, i, 1);
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}

	static int go(int[] arr, int joker, int i, int cnt) {
		int cur = arr[i];
		int next = arr[i + 1];
		int gap = next - cur;
		if (gap == 0) {
			return go(arr, joker, i + 1, cnt);
		}
		if (cur + 1 == next) {
			return Math.max(cnt, go(arr, joker, i + 1, cnt + 1));
		} else if (gap - 1 > joker) { // 조커 못 쓸 때
			return cnt + joker;
		} else if (gap - 1 <= joker) {// 조커 쓸 때
			return Math.max(cnt, go(arr, joker - gap + 1, i + 1, cnt + gap));
		}
		return cnt;
	}
}
