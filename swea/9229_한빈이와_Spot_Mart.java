import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<>();
			int min = Integer.MAX_VALUE;
			String str2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str2);
			
			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(st2.nextToken());
				if (input < M) {
					list.add(input);
					min = Math.min(min, input);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (min + list.get(i) > M) {
					list.remove(i);
					i--;
				}
			}
			int sum = 0;
			int max = 0;
			if (list.size() == 1 || list.isEmpty()) {
				max = -1;
			} else {
				for (int i = 0; i < list.size() - 1; i++) {
					for (int j = i + 1; j < list.size(); j++) {
						sum = list.get(i) + list.get(j);
						if (sum > M) {
							continue;
						} else {
							max = Math.max(max, sum);
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
